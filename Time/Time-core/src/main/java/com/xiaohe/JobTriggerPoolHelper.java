package com.xiaohe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName JobTriggerPoolHelper
 * @Description 调度中心给程序发送消息的类
 * @Author 何
 * @Date 2023-08-11 15:53
 * @Version 1.0
 */
public class JobTriggerPoolHelper {
    private static Logger logger = LoggerFactory.getLogger(JobTriggerPoolHelper.class);

    private ThreadPoolExecutor fastTriggerPool = null;
    private ThreadPoolExecutor slowTriggerPool = null;
    private static JobTriggerPoolHelper helper = new JobTriggerPoolHelper();

    public static JobTriggerPoolHelper getInstance() {
        return helper;
    }

    /**
     * 对外暴露的开始方法
     */
    public static void toStart() {
        helper.start();
    }

    /**
     * 对外暴露的结束方法
     */
    public static void toStop() {
        helper.stop();
    }

    public void start() {
        // 快线程池，最大线程数为200
        fastTriggerPool = new ThreadPoolExecutor(
                10,
                200,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000),
                r -> new Thread(r, "xxl-job, admin JobTriggerPoolHelper-fastTriggerPool-" + r.hashCode()));

        // 慢线程池，最大线程数为100
        slowTriggerPool = new ThreadPoolExecutor(
                10,
                100,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2000),
                r -> new Thread(r, "xxl-job, admin JobTriggerPoolHelper-slowTriggerPool-" + r.hashCode()));
    }
    public void stop() {
        fastTriggerPool.shutdownNow();
        slowTriggerPool.shutdownNow();
    }

    public static void trigger(TimeJobInfo timeJobInfo) {
        helper.addTrigger(timeJobInfo);
    }

    // 获取当前系统时间，这里计算出来的其实是系统当前的分钟数
    private volatile long minTim = System.currentTimeMillis() / 60000;

    /**
     * 如果有任务出现慢执行情况了 (执行耗时 500ms)，就会被记录在这个 Map 中
     * key: 任务id
     * value: 一分钟慢执行次数
     * 如果一分钟内，某任务慢执行次数超过了10次，该任务就会被交给慢线程池调度。
     * 并且这个Map会一分钟清理一次。
     */
    private volatile ConcurrentMap<Integer, AtomicInteger> jobTimeoutCountMap = new ConcurrentHashMap<>();

    public void addTrigger(TimeJobInfo timeJobInfo) {
        // 默认使用快线程池
        ThreadPoolExecutor triggerPool = fastTriggerPool;
        // 用此任务id从 Map 中获取慢执行次数
        AtomicInteger atomicInteger = jobTimeoutCountMap.get(timeJobInfo.getId());
        // 如果慢执行次数大于10，交给慢线程池调度
        if (!Objects.isNull(atomicInteger) && atomicInteger.get() > 10) {
            triggerPool = slowTriggerPool;
        }
        triggerPool.execute(() -> {
            // 获取开始调度的时间
            long start = System.currentTimeMillis();
            try {
                TimeTrigger.trigger(timeJobInfo);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            } finally {
                // 调度完再次获取时间，如果超过500ms，判定为一次慢执行
                // 先判断分钟是否相同，不相同清空重新计算。
                long minTimNow = System.currentTimeMillis() / 60000;
                if (minTim != minTimNow) {
                    minTim = minTimNow;
                    jobTimeoutCountMap.clear();
                }
                long cost = System.currentTimeMillis() - start;
                if (cost > 500) {
                    AtomicInteger timeoutCount = jobTimeoutCountMap.putIfAbsent(timeJobInfo.getId(), new AtomicInteger(1));
                    if (!Objects.isNull(timeoutCount)) {
                        timeoutCount.incrementAndGet();
                    }

                }
            }

        });

    }
}
