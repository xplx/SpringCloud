package com.example.comsumer.controller.feignClient;

import com.example.comsumer.server.HelloRemote;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuxiaopeng
 * @create 2018-07-05 14:39
 **/

@RestController
public class ConsumerController {

    //@FeignClient声明的只能使用@Resource进行注解，不能使用@Autowired
    @Resource
    HelloRemote HelloRemote;

    //获取配置属性
    @Value("${my.name}")
    private String myName;

    @HystrixCommand(fallbackMethod = "hiError") //声明断路点HystrixCommand
    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {

        return HelloRemote.hello(name + " my name:" + myName);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}