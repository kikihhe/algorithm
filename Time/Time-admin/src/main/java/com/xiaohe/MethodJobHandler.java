package com.xiaohe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName MethodJobHandler
 * @Description 封装定时任务 类及方法
 * @Author 何
 * @Date 2023-08-12 12:18
 * @Version 1.0
 */
public class MethodJobHandler {
    /**
     * 定时任务所在的类
     */
    private Object target;

    /**
     * 定时任务所在的方法
     */
    private Method method;

    /**
     * 执行定时任务
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void execute() throws InvocationTargetException, IllegalAccessException {
        method.invoke(target);
    }

    public MethodJobHandler() {
    }

    public MethodJobHandler(Object target, Method method) {
        this.target = target;
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

}
