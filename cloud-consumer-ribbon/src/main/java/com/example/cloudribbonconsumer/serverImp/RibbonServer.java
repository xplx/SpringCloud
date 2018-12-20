package com.example.cloudribbonconsumer.serverImp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuxiaopeng
 * @create 2018-07-13 14:12
 **/
@Service
public class RibbonServer {
    @Autowired
    RestTemplate restTemplate;
    //有了@HystrixCommand注解，hi（）方法就启用 Hystrix 熔断器的功能，
    // 其中,fallbackMethod 为处理回退（ fallback ）逻辑的方法。
    // fallback 的逻辑最好是返回一些静态的字符串，不需要处理复杂的逻辑.
    //目的：这样做的好处就是通过快速失败，请求能够得到及时处理，线程不再阻塞。
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(String name){
        //在该类的 hi（）方法用 restTemplate 调用 eureka-client 的 API 接口 ，
        //此时 Uri 上不需要使用硬编码（例如 IP 地址 ），只需要写服务名 eureka-client 即可
        return restTemplate.getForObject("http://cloud-producer/hello?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi, name" + name + "sorry, error";
    }
}