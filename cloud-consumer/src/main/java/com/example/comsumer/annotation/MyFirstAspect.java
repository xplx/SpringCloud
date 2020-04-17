package com.example.comsumer.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description:注解切面实现
 * @author:wuxiaopeng
 * @create: 2019-06-04 11:48
 **/
@Aspect
@Component
public class MyFirstAspect {

    /**
     * 定义一个切入点
     */
    @Pointcut("@annotation(com.example.comsumer.annotation.MyFirstAnnotation)")
    public void annotationPointcut() {
    }

    /**
     * 加入切点
     * @param joinPoint
     */
    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        MyFirstAnnotation annotation = method.getAnnotation(MyFirstAnnotation.class);
        //获取注解值
        String value = annotation.value();
        System.out.println("准备"+value);
    }

    @After("annotationPointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        MyFirstAnnotation annotation = method.getAnnotation(MyFirstAnnotation.class);
        String value = annotation.value();
        System.out.println("结束"+value);
    }
}
