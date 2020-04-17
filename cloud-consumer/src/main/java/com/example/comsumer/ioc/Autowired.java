package com.example.comsumer.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @author:wuxiaopeng
 * @create: 2019-06-04 19:15
 **/
//依赖注入注解,只能通过反射获取
@Retention(RetentionPolicy.RUNTIME)
//只能注解到字段上
@Target(ElementType.FIELD)
public @interface Autowired {
}
