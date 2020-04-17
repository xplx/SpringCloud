package com.example.comsumer.ioc;

/**
 * @author DELL
 * 用来获取bean对象的方法
 */
public interface Application {
    Object getBean(String beanName);
}
