package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 项目就具有了服务注册的功能。启动工程后，就可以在注册中心的页面看到CLOUD-PRODUCER服务。向注册中心注册方法
 * Turbine 同时监控多个服务组件，需要加入如下两个注解：@EnableHystrixDashboard@EnableHystrix
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableHystrix
public class Producer  {

	public static void main(String[] args) {
		SpringApplication.run(Producer.class, args);
	}
}
