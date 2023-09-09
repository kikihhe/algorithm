package com.xiaohe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

/**
 * @ClassName TimeTrigger
 * @Description 进行远程调度
 * @Author 何
 * @Date 2023-08-11 15:56
 * @Version 1.0
 */
public class TimeTrigger {
    private static Logger logger = LoggerFactory.getLogger(TimeTrigger.class);

    public static void trigger(TimeJobInfo timeJobInfo) {
        processTrigger(timeJobInfo);
    }

    private static void processTrigger(TimeJobInfo timeJobInfo) {
        // 初始化触发器参数
        TriggerParam triggerParam = new TriggerParam(timeJobInfo.getExecutorHandler());
        // 选取第一个程序作为执行器
        String address = timeJobInfo.getRegistryList().get(0);
        triggerResult = runExecutor(triggerParam, address);
    }

    public static ReturnT<String> runExecutor(TriggerParam triggerParam, String address) {
        // 在这里把消息发送给定时任务执行程序
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setReadTimeout(3 * 1000);
            connection.setConnectTimeout(3 * 1000);
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setRequestProperty("Accept-Charset", "application/json;charset=UTF-8");

            connection.connect();
            // 设置请求体
            if (!Objects.isNull(triggerParam)) {
                String requestBody = GsonTool.toJson(triggerParam);
                DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
                dataOutputStream.write(requestBody.getBytes("UTF-8"));
                // 刷新缓冲区
                dataOutputStream.flush();
                // 释放资源
                dataOutputStream.close();
            }

            // 获取响应码
            int responseCode = connection.getResponseCode();
            // 失败
            if (responseCode != 200) {
                return new ReturnT<String>(ReturnT.FAIL_CODE, "Time remoting fail, StatusCode(" + responseCode + ")invalid. for url : " + url);
            }
            // 成功, 接收返回结果
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder result = new StringBuilder();
            String line;
            while (!(line = bufferedReader.readLine()).isEmpty()) {
                result.append(line);
            }
            String resultJson = result.toString();
            try {
                ReturnT returnT = GsonTool.fromJson(resultJson, ReturnT.class, returnTargClassOfT);
                return returnT;

            }catch (Exception e) {
                logger.error(e.getMessage(), e);
                return new ReturnT<String>(ReturnT.FAIL_CODE, "Time remoting (url=" + url + ") response content invalid(" + e.getMessage() + ").")
            }


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ReturnT<String>(ReturnT.FAIL_CODE, "Time remoting (url=" + url + ") response content invalid(" + e.getMessage() + ").")
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (connection != null) connection.disconnect();
            } catch (Exception e2) {
                logger.error(e2.getMessage(), e2);
            }
        }
    }
}
