package com.example.comsumer.server;

import com.example.comsumer.controller.RemoteHystrix.HelloRemoteHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 在HelloRemote类添加指定fallback类，在服务熔断的时候返回fallback类中的内容。
 * name：名称用来创建负载均衡器。
 */
@FeignClient(name= "cloud-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);
}
