package com.example.cloudribbonconsumer.controller;

import com.example.cloudribbonconsumer.serverImp.RibbonServer;
import com.example.cloudribbonconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @create 2018-07-13 14:23
 **/
@RestController
public class RibbonController {
    @Autowired
    private RibbonServer ribbonServer;

    @Autowired
    private HelloService helloService;

    /**
     * 负载均衡获取轮询获取服务提供者
     * @param name
     * @return
     */
    @GetMapping("/hello")
    public String hello(@RequestParam (required = false, defaultValue ="wuxiaopeng") String name)  {
        return ribbonServer.hi(name);
    }
    /**
     * 负载均衡获取轮询获取服务提供者,采用feign方式
     * @param name
     * @return
     */
    @GetMapping("/helloFeign")
    public String helloFeign(@RequestParam (required = false, defaultValue ="wuxiaopeng") String name)  {
        return helloService.hello(name);
    }
}