package com.example.cloudribbonconsumer.service.impl;

import com.example.cloudribbonconsumer.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//log便捷开发
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        log.info("调用失败");
        return "hello fail";
    }
}
