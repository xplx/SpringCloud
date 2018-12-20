package com.example.cloudribbonconsumer.util;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 改类配置feign的配置类
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public Contract feignContract(){
        //原生的默认契约
        return new feign.Contract.Default();
    }
}
