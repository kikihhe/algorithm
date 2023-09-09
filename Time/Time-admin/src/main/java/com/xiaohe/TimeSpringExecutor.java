package com.xiaohe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.MethodIntrospector;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName TimeSpringExecutor
 * @Description 获取Spring容器中的定时任务类
 * @Author 何
 * @Date 2023-08-12 12:22
 * @Version 1.0
 */
public class TimeSpringExecutor extends TimeExecutor implements ApplicationContextAware, SmartInitializingSingleton {
    private static final Logger logger = LoggerFactory.getLogger(TimeSpringExecutor.class);

    /**
     * 本项目自己的容器 (直接使用Spring容器)
     */
    private static ApplicationContext applicationContext;

    /**
     * 容器中所有bean对象创建后被回调
     */
    @Override
    public void afterSingletonsInstantiated() {
        initJobHandlerMethodRepository(applicationContext);
        start();
    }

    /**
     * Spring容器启动后回调，在此处获取Spring容器
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TimeSpringExecutor.applicationContext = applicationContext;
    }

    /**
     * 将定时任务对象封装到 Map 中
     * 从application中获取加了 @Time 注解的bean实例
     *
     * @param applicationContext
     */
    private void initJobHandlerMethodRepository(ApplicationContext applicationContext) {
        if (Objects.isNull(applicationContext)) {
            return;
        }
        // 获取容器中所有bean的名字
        String[] beanDefinitionNames = applicationContext.getBeanNamesForType(Object.class);
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            // 收集bean中加了 @Time 注解的方法
            Map<Method, Time> annotatedMethods = null;
            try {
                annotatedMethods = MethodIntrospector.selectMethods(
                                                bean.getClass(),
                        (MethodIntrospector.MetadataLookup<Time>) method
                                -> AnnotatedElementUtils.findMergedAnnotation(method, Time.class)
                );
            } catch (Throwable tw) {
                logger.error("Time method-jobhandler resolve error for bean[" + beanDefinitionName + "].", tw);
            }
            // 如果这个bean中没有加Time注解，下一个
            if (annotatedMethods.isEmpty()) {
                continue;
            }
            for (Map.Entry<Method, Time> methodTimeEntry : annotatedMethods.entrySet()) {
                Method executeMethod = methodTimeEntry.getKey();
                // Time注解中包含定时任务的名称
                Time annotation = methodTimeEntry.getValue();
                registJobHandler(annotation, bean, executeMethod);

            }



        }

    }
}
