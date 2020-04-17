package com.example.comsumer.controller.RemoteHystrix;

import com.example.comsumer.server.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuxiaopeng
 * @create 2018-07-05 15:38
 * 创建HelloRemoteHystrix类继承与HelloRemote实现回调的方法,根据返回结果说明熔断成功。
 **/

@Service
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello " +name+", this messge send failed ";
    }
}