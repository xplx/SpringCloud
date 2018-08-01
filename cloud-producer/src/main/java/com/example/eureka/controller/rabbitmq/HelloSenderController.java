package com.example.eureka.controller.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wuxiaopeng
 * @create 2018-07-24 10:49
 * mq接收信息
 **/
@RestController
public class HelloSenderController {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RequestMapping(value = "/sendHello")
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}   