package com.xiaohe;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.FailedFuture;
import io.netty.util.internal.ThrowableUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName EmbedHttpServerHandler
 * @Description TODO
 * @Author 何
 * @Date 2023-08-12 15:23
 * @Version 1.0
 */
public class EmbedHttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private ThreadPoolExecutor bizThreadPool;
    public EmbedHttpServerHandler(ThreadPoolExecutor bizThreadPool) {
        this.bizThreadPool = bizThreadPool;
    }

    @Override
    protected void channelRead0(final ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        // 获取调度中心发送的消息 (TriggerParam)
        String requestData = msg.content().toString();
        HttpMethod httpMethod = msg.method();
        // 判断http连接是否还活着
        boolean keepAlive = HttpUtil.isKeepAlive(msg);
        bizThreadPool.execute(() -> {
            // 去执行，获取返回结果
            Object responseObj = process(httpMethod, requestData);
            String responseJson = GsonTool.toJson(responseObj);
            // 把消息回复给调度中心，这里的回复消息的动作是业务线程发起的。
            // 但是真正发送消息还是netty的单线程完成的。
            writeResponse(ctx, keepAlive, responseJson);
        });

    }

    private Object process(HttpMethod httpMethod, String requestData) {
        if (!HttpMethod.POST.equals(httpMethod)) {
            return new ReturnT<String>(ReturnT.FAIL_CODE, "invalid request, HttpMethod not support.");
        }
        try {
            TriggerParam triggerParam = GsonTool.fromJson(requestData, TriggerParam.class);
            JobThread jobThread = TimeExecutor.loadJobThread(triggerParam.getJobId());
            if (jobThread != null) {
                // 如果执行器已经给这个任务创建了一个线程
                ReturnT<String> pushResult = jobThread.pushTriggerQueue(triggerParam);
            }
            // 如果执行器没有创建线程, 第一次给某一个定时任务创建指定的线程
            String jobName = triggerParam.getExecutorHandler();
            MethodJobHandler jobHandler = TimeExecutor.loadJobHandler(jobName);
            jobThread = TimeExecutor.registJobThread(triggerParam.getJobId(), jobHandler);
            return jobThread.pushTriggerQueue(triggerParam);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ReturnT<String>(ReturnT.FAIL_CODE, "request error: " + ThrowableUtil.toString(e));
        }
    }

}
