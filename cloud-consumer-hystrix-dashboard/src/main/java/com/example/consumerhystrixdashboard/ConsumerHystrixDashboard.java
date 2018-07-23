package com.example.consumerhystrixdashboard;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableHystrix //开启断路器
@EnableHystrixDashboard //开启HystrixDashboard
@EnableCircuitBreaker //熔断器（CircuitBreaker）
@EnableTurbine //Turbine 用于聚合多个 Hystrix Dashboard
public class ConsumerHystrixDashboard {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerHystrixDashboard.class, args);
	}

	@Value("${server.port}")
	String port;
	//如果没有请求会先显示Loading ...，访问http://localhost:9004/hystrix.stream 也会不断的显示ping。
	@RequestMapping("/hello")
	@HystrixCommand(fallbackMethod = "hiError") //声明断路点HystrixCommand
	public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}

	public String hiError(String name) {
		return "hi,"+name+",sorry,error!";
	}
}
