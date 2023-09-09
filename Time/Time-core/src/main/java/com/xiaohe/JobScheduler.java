package com.xiaohe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName JobScheduler
 * @Description 调度中心
 * @Author 何
 * @Date 2023-08-11 15:46
 * @Version 1.0
 */
public class JobScheduler {
    private static final Logger logger = LoggerFactory.getLogger(JobScheduler.class);

    public void init() {
        // 创建调度任务的线程池
        JobTriggerPoolHelper.toStart();
        // 开始扫描数据库的定时任务
        JobScheduleHelper.getInstance().start();
    }
}
