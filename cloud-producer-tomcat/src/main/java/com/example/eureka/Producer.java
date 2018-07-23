package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 单独部署服务器，不适用Spring boot下面自带的tomcat
 */
//项目就具有了服务注册的功能。启动工程后，就可以在注册中心的页面看到SPRING-CLOUD-PRODUCER服务。向注册中心注册方法
@EnableDiscoveryClient
@SpringBootApplication
public class Producer extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Producer.class, args);
	}

	//3.让启动SpringBoot的类继承SpringBootServletInitializer并实现它的configure方法
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}
}
