package com.example.springBootDemo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @create 2018-05-28 13:38
 **/
//的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了!
@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}   