package com.example.cloudribbonconsumer.controller;

import com.example.cloudribbonconsumer.serverImp.RibbonServer;
import com.example.cloudribbonconsumer.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author wuxiaopeng
 * @create 2018-07-13 14:23
 **/
@RestController
public class RibbonController {
    @Resource
    private RibbonServer ribbonServer;

//    @Resource
//    private HelloService helloService;
    /**
     * 负载均衡获取轮询获取服务提供者
     * @param name
     * @return
     */
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false, defaultValue = "wuxiaopeng") String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss:SSS");
        System.out.println("begin"+ sdf.format(new Date()));
        return ribbonServer.hi(name);
    }

    /**
     * 负载均衡获取轮询获取服务提供者,采用feign方式
     *
     * @param name
     * @return
     */
//    @GetMapping("/helloFeign")
//    public String helloFeign(@RequestParam(required = false, defaultValue = "wuxiaopeng") String name) {
//        return helloService.hello(name);
//    }
}