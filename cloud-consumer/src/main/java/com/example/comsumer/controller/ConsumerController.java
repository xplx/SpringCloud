package com.example.comsumer.controller;

import com.example.comsumer.server.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuxiaopeng
 * @create 2018-07-05 14:39
 **/

@RestController
public class ConsumerController {

    //@FeignClient声明的只能使用@Resource进行注解，不能使用@Autowired
    @Resource
    HelloRemote HelloRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return HelloRemote.hello(name);
    }

}