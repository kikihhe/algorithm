package com.xiaohe;

/**
 * @ClassName RegistyParam
 * @Description 定时任务创建后向调度中心发送的基本信息
 * @Author 何
 * @Date 2023-08-11 15:18
 * @Version 1.0
 */
public class RegistyParam {
    /**
     * 定时任务名称
     */
    private String registryKey;

    /**
     * 该定时任务对应的IP地址
     */
    private String registryValue;

    public RegistyParam() {
    }

    public RegistyParam(String registryKey, String registryValue) {
        this.registryKey = registryKey;
        this.registryValue = registryValue;
    }

    public String getRegistryKey() {
        return registryKey;
    }

    public void setRegistryKey(String registryKey) {
        this.registryKey = registryKey;
    }

    public String getRegistryValue() {
        return registryValue;
    }

    public void setRegistryValue(String registryValue) {
        this.registryValue = registryValue;
    }
}
