package com.example.eureka.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @create 2018-05-28 13:38
 **/
//的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了!
@RestController
public class HelloWorldController {
    //忽略改接口
    //@ApiIgnore
    @RequestMapping("/hello")
    //在方法上加上＠HystrixCommand 注解 ， 该注解用于创建一个熔断器，井指明 fallbackMethod （回退方法）为“ hiError” 方法。
    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(@RequestParam String name) {
        return "hello "+name+"，this is producer 1  send first message";
    }
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}   