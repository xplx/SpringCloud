package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//项目就具有了服务注册的功能。启动工程后，就可以在注册中心的页面看到SPRING-CLOUD-PRODUCER服务。
@EnableDiscoveryClient
@SpringBootApplication
public class Producer1 {

	public static void main(String[] args) {
		SpringApplication.run(Producer1.class, args);
	}
}
