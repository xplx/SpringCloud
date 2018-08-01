package com.example.config.controller.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wuxiaopeng
 * @create 2018-07-24 10:36
 * 高级消息队列协议，
 **/
@RestController
public class SendController {
    private final static String QUEUE_NAME = "hello";
    //amq模板队列
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @RequestMapping(value = "/sendMq")
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}   