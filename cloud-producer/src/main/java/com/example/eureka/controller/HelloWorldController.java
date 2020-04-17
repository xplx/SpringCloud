package com.example.eureka.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wuxiaopeng
 * @create 2018-05-28 13:38
 **/
//的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了!
@RestController
public class HelloWorldController{
    private final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        logger.info("request two name is "+ name);
        try {
            Thread.sleep(10000,10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return "hello "+name+"，this is producer 11111 send first message,time: "+ sdf.format(new Date());
    }
}   