package com.xiaohe;

import java.lang.annotation.*;

/**
 * @ClassName Time
 * @Description
 * @Author 何
 * @Date 2023-08-12 12:30
 * @Version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Time {

    /**
     * 定时任务的名称
     * @return
     */
    String value();
}
