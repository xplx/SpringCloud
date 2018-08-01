package com.example.eureka.util;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * @author wuxiaopeng
 * @create 2018-07-24 10:48
 **/

public class RabbitConfig {
    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }
}   