package com.xiaohe;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @ClassName EmbedServer
 * @Description 执行器端服务器的启动类, 以Netty构建
 * @Author 何
 * @Date 2023-08-12 15:13
 * @Version 1.0
 */
public class EmbedServer {
    private static final Logger logger = LoggerFactory.getLogger(EmbedServer.class);

    /**
     * 启动执行器的内嵌服务器，其中address参数就是执行器的IP地址，要封装到RegistryParam对象中
     * 发送给调度中心的，port为Netty构建的服务器要使用的端口号
     * appname为执行器配置文件中用户设定的执行器的唯一标识，也是要封装到RegistryParam对象中
     * 发送给调度中心的
     * @param address
     * @param port
     * @param appname
     */
    public void start(final String address, final int port, final String appname) {

        //下面都是netty的知识，学过手写netty的应该都清楚，就不再一一解释了
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //这就是我先创建好的业务线程池
        ThreadPoolExecutor bizThreadPool = new ThreadPoolExecutor(
                0,
                200,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2000),
                r -> new Thread(r, "Time, EmbedServer bizThreadPool-" + r.hashCode()),
                (r, executor) -> {
                    throw new RuntimeException("Time, EmbedServer bizThreadPool is EXHAUSTED!");
                });

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline()
                                    //心跳检测
                                    .addLast(new IdleStateHandler(0, 0, 30 * 3, TimeUnit.SECONDS))
                                    //http的编解码器，该处理器既是出站处理器，也是入站处理器
                                    .addLast(new HttpServerCodec())
                                    //这个处理器从名字上就能看出来，是聚合消息的，当传递的http消息过大时，会被拆分开，这里添加这个处理器
                                    //就是把拆分的消息再次聚合起来，形成一个整体再向后传递
                                    //该处理器是个入站处理器
                                    .addLast(new HttpObjectAggregator(5 * 1024 * 1024))
                                    //添加入站处理器，在该处理器中执行定时任务
                                    //把业务线程池交给EmbedHttpServerHandler处理器使用
                                    .addLast(new EmbedHttpServerHandler(bizThreadPool));
                        }
                    })
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // 绑定端口号
            ChannelFuture future = bootstrap.bind(port).sync();
            // 注册执行器到调度中心
            startRegistry(appname, address);
            //等待关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            logger.info(">>>>>>>>>>> xxl-job remoting server stop.");
        }finally {
            try {
                //优雅释放资源
                workerGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }
}
