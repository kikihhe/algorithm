package com.xiaohe;

import org.springframework.scheduling.Trigger;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName JobThread
 * @Description 定时任务线程。每一个线程中维护一个定时任务
 * @Author 何
 * @Date 2023-08-12 15:42
 * @Version 1.0
 */
public class JobThread extends Thread {
    /**
     * 线程对应的定时任务id
     */
    private Integer jobId;

    /**
     * 该任务所在的 类 + 方法
     */
    private MethodJobHandler methodJobHandler;

    /**
     * 存放触发器参数的一个队列，有可能一个任务比较耗时，3秒还没执行完，但调度周期是2秒，
     * 那么之后每2秒要执行的这个定时任务可能就会放在JobThread对象中的队列中等待执行，
     * 其实存放的就是触发器参数，触发器参数中有待执行的定时任务的名称和id
     */
    private LinkedBlockingQueue<TriggerParam> triggerQueue;

    /**
     * 线程终止的标记
     */
    private volatile boolean toStop = false;

    public JobThread(Integer jobId, MethodJobHandler methodJobHandler) {
        this.jobId = jobId;
        this.methodJobHandler = methodJobHandler;
        this.triggerQueue = new LinkedBlockingQueue<>();
        // 设置线程名
        this.setName("Time, JobThread-" + jobId + "-" + System.currentTimeMillis());
    }

    /**
     * 把调度中心发来的触发参数放入队列
     * @param triggerParam 触发参数
     * @return
     */
    public ReturnT<String> pushTriggerQueue(TriggerParam triggerParam) {
        triggerQueue.add(triggerParam);
        return ReturnT.SUCCESS;
    }

    @Override
    public void run() {
        while (!toStop) {
            TriggerParam triggerParam = null;
            try {
                // 阻塞地从队列中取出触发参数，如果超过3s就不阻塞了。
                triggerParam = triggerQueue.poll(3L, TimeUnit.SECONDS);
                if (!Objects.isNull(triggerParam)) {
                    methodJobHandler.execute();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
