package com.xiaohe;

import io.netty.util.NetUtil;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @ClassName TimeExecutor
 * @Description 公共父类执行器，将加了定时任务注解的信息封装起来
 * @Author 何
 * @Date 2023-08-12 12:45
 * @Version 1.0
 */
public class TimeExecutor {
    /**
     * 下面这些成员变量都是定义在配置文件中的，而这里的属性，会在用户自己定义的XxlJobConfig配置类中被赋值成功
     * 服务器的地址，也就是调度中心的地址，执行器要注册到调度中心那一端
     * 这两个属性都会由SpringBoot帮我们从配置文件中得到对应的值，然后赋值给它们
     */
    private String adminAddresses;

    /**
     * 这个就是执行器的名称，注册执行器到调度中心的时候，使用的就是这个名称
     */
    private String appname;

    /**
     * 存放 MethodJobHandler 对象的Map
     */
    private static ConcurrentMap<String, MethodJobHandler> jobHandlerRepository = new ConcurrentHashMap<String, MethodJobHandler>();

    /**
     * kye : 定时任务id
     * value : 执行这个定时任务的线程
     */
    private static ConcurrentMap<Integer, JobThread> jobThreadRepository = new ConcurrentHashMap<>();

    protected void registJobHandler(Time time, Object bean, Method executeMethod) {
        if (Objects.isNull(time)) {
            return;
        }
        // 指定的定时任务名称
        String name = time.value();
        // 类的class对象
        Class<?> clazz = bean.getClass();
        // 需要调用的方法名称
        String methodName = executeMethod.getName();
        if (!StringUtils.hasText(name)) {
            throw new RuntimeException("Time method-jobhandler name invalid, for[" + clazz + "#" + methodName + "] .");
        }
        // 判断定时任务名称是否重复
        if (!Objects.isNull(loadJobHandler(name))) {
            throw new RuntimeException("Time jobhandler[" + name + "] naming conflicts.");
        }
        // 设置方法可访问
        executeMethod.setAccessible(true);
        // 装入Map
        registJobHandler(name, new MethodJobHandler(bean, executeMethod));
    }

    /**
     * 根据定时任务的名称获取对应的 MethodJobHandler
     *
     * @param name
     * @return
     */
    public static MethodJobHandler loadJobHandler(String name) {
        return jobHandlerRepository.get(name);
    }

    /**
     * 封装
     *
     * @param name
     * @param jobHandler
     * @return
     */
    public static MethodJobHandler registJobHandler(String name, MethodJobHandler jobHandler) {
        return jobHandlerRepository.put(name, jobHandler);
    }

    /**
     * 启动执行器的服务端
     */
    public void start() {
        // 启动执行器内部内嵌的服务器，该服务器是用Netty构建的，但构建的是http服务器，仍然是用http来传输消息的
        // 并且，在该方法中会进一步把执行器注册到调度中心上
        initEmbedServer(appname, adminAddresses);
    }

    /**
     * 启动执行器内嵌的 Netty服务器，把执行器注册到调度中心
     * @param appname
     * @param adminAddresses
     */
    private void initEmbedServer(String appname, String adminAddresses) {
        // 默认使用9999端口
        String port = NetUtil.findAvailablePort(9999);
        // 得到默认IP地址
        String ip = IpUtil.getIp();
        String ip_port_address = NetUtil.getIpPort(ip, port);
        String address = "http://{ip_port}/".replace("{ip_port}", ip_port_address);
        // 创建执行器端的Netty服务器
        embedServer = new EmbedServer();
        embedServer.start(address, port, appname);

    }

    /**
     * 将 定时任务id + 执行类&方法 放入Map中, 并启动线程执行此任务
     * @param jobId
     * @param handler
     * @return
     */
    public static JobThread registJobThread(Integer jobId, MethodJobHandler handler) {
        JobThread newJobThread = new JobThread(jobId, handler);
        // 创建之后就启动线程。
        newJobThread.start();
        jobThreadRepository.put(jobId, newJobThread);
        return newJobThread;
    }

    /**
     * 根据定时任务id获取执行它的线程。
     * @param jobId 定时任务id
     * @return
     */
    public static JobThread loadJobThread(Integer jobId) {
        return jobThreadRepository.get(jobId);
    }



}
