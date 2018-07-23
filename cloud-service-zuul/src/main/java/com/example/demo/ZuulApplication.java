package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 在 Zuul 上配置熔断器
 */
@SpringBootApplication //Spring Boot工程
@EnableZuulProxy //支持网关路由
@EnableDiscoveryClient //自动寻找注册中心（Eureka和zookeeper）,@EnableEurekaClient //注册中心使用Eureka
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
