package com.xiaohe;

/**
 * @ClassName TriggerParam
 * @Description 调度中心通知程序执行的信息
 * @Author 何
 * @Date 2023-08-11 15:49
 * @Version 1.0
 */
public class TriggerParam {

    private Integer jobId;



    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    private String executorHandler;

    public TriggerParam() {
    }

    public TriggerParam(String executorHandler) {
        this.executorHandler = executorHandler;
    }

    public String getExecutorHandler() {
        return executorHandler;
    }

    public void setExecutorHandler(String executorHandler) {
        this.executorHandler = executorHandler;
    }
}
