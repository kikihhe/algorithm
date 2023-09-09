package com.xiaohe;

import java.util.List;

/**
 * @ClassName RegistryParam
 * @Description 执行器的客户端向调度器发送的消息
 * @Author 何
 * @Date 2023-08-12 13:01
 * @Version 1.0
 */
public class RegistryParam {
    /**
     * 执行器的名称 appName
     */
    private String registryKey;

    /**
     * 本服务器IP地址
     */
    private String registryValue;

    public RegistryParam() {
    }

    public RegistryParam(String registryKey, String registryValue) {
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
