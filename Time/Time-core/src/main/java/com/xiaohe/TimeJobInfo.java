package com.xiaohe;

import java.util.List;

/**
 * @ClassName TimeJobInfo
 * @Description 定时任务的信息
 * @Author 何
 * @Date 2023-08-11 14:25
 * @Version 1.0
 */
public class TimeJobInfo {
    private Integer id;



    public TimeJobInfo(Integer id, String executorHandler, long triggerNextTime, List<String> registryList) {
        this.id = id;
        this.executorHandler = executorHandler;
        this.triggerNextTime = triggerNextTime;
        this.registryList = registryList;
    }

    /**
     * 定时任务的名称
     */
    private String executorHandler;

    /**
     * 定时任务的下次执行时间
     */
    private long triggerNextTime;

    /**
     * 离现在最近的一次已经调度的时刻
     */
    private long triggerLastTime;

    /**
     * 调度状态
     */
    private int triggerStatus;

    /**
     * 该定时任务的部署实例IP地址
     */
    private List<String> registryList;


    public long getTriggerLastTime() {
        return triggerLastTime;
    }

    public void setTriggerLastTime(long triggerLastTime) {
        this.triggerLastTime = triggerLastTime;
    }

    public int getTriggerStatus() {
        return triggerStatus;
    }

    public void setTriggerStatus(int triggerStatus) {
        this.triggerStatus = triggerStatus;
    }

    public String getScheduledConf() {
        return scheduledConf;
    }


    public void setScheduledConf(String scheduledConf) {
        this.scheduledConf = scheduledConf;
    }

    private String scheduledConf;

    public TimeJobInfo(Integer id, String executorHandler, long triggerNextTime, List<String> registryList, String scheduledConf) {
        this.id = id;
        this.executorHandler = executorHandler;
        this.triggerNextTime = triggerNextTime;
        this.registryList = registryList;
        this.scheduledConf = scheduledConf;
    }

    public TimeJobInfo() {
    }

    public TimeJobInfo(String executorHandler, long triggerNextTime, List<String> registryList) {
        this.executorHandler = executorHandler;
        this.triggerNextTime = triggerNextTime;
        this.registryList = registryList;
    }

    public TimeJobInfo(String executorHandler, long triggerNextTime) {
        this.executorHandler = executorHandler;
        this.triggerNextTime = triggerNextTime;
    }



    public String getExecutorHandler() {
        return executorHandler;
    }

    public void setExecutorHandler(String executorHandler) {
        this.executorHandler = executorHandler;
    }

    public long getTriggerNextTime() {
        return triggerNextTime;
    }

    public void setTriggerNextTime(long triggerNextTime) {
        this.triggerNextTime = triggerNextTime;
    }

    public List<String> getRegistryList() {
        return registryList;
    }

    public void setRegistryList(List<String> registryList) {
        this.registryList = registryList;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
