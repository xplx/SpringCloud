package com.example.cloudribbonconsumer.util;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuxiaopeng
 * @create 2018-07-13 14:09
 * 此时 RestTemplate 就结合了阳Ribbon 开启了负载均衡功能
 **/
@Configuration
public class RibbonConfig {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}   