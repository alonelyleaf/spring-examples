package com.alonelyleaf.spring.aop.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author bijl
 * @date 2020/12/21 上午10:43
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionReTry {

    Class<? extends Exception>[] value() default {};

    int retryTimes() default 3;

    int sleep() default 1000;
}
