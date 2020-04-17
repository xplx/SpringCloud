package com.example.cloudribbonconsumer.service;


import com.example.cloudribbonconsumer.service.impl.HelloServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 在HelloRemote类添加指定fallback类，在服务熔断的时候返回fallback类中的内容。
 * name：名称用来创建负载均衡器。
 */
@FeignClient(name= "cloud-producer",fallback = HelloServiceImpl.class)
public interface HelloService {
    @RequestMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);
}
