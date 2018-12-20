package com.example.cloudribbonconsumer.service;

import com.example.cloudribbonconsumer.service.impl.HelloServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "cloud-producer",fallback = HelloServiceImpl.class)
public interface HelloService {
    @GetMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);
}
