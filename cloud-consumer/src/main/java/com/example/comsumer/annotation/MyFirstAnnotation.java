package com.example.comsumer.annotation;

import java.lang.annotation.*;

/**
 * @author wuxiaopeng
 * @Data 2019-06-04
 * @deprecated 用于自定义注解
 * Retention：保留至运行时，通过反射去获取注解信息。
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyFirstAnnotation {
    String value() default "";
}
