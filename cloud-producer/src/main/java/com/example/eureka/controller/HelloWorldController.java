package com.example.eureka.controller;

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
    public String index(@RequestParam String name) {
        return "hello "+name+"，this is producer 1  send first message";
    }
}   