package com.example.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @create 2018-07-09 11:31
 **/
//加上该配置不重启服务打的情况下更新配置
@RefreshScope
@RestController
public class GetRemoteController {
    @Value("${neo.hello}")
    private String hello;

    @RequestMapping("/hello")
    public String from() {
        return this.hello;
    }
}   