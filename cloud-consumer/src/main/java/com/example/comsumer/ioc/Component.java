package com.example.comsumer.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-06-04 19:17
 **/
//组件注解
@Retention(RetentionPolicy.RUNTIME) //程序运行时执行
@Target(ElementType.TYPE)   //该注解指定标注的位置    TYPE:类
public @interface Component {
}
