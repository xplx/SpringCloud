package com.example.eureka.controller;

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
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        System.out.println("hello");
        try {
            Thread.sleep(50000,10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return "hello "+name+"，this is producer 22222 send two message,time: "+ sdf.format(new Date());
    }
}   