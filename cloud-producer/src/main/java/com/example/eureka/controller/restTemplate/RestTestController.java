package com.example.eureka.controller.restTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuxiaopeng
 * @create 2018-07-13 13:42
 * RestTemplate 的使用很简单，它支持 Xml 、 JSON数据格式，默认实现了序列化，可以自动将 JOSN 字符串转换为实体。
 **/
@RestController
public class RestTestController {
    @GetMapping("/testRest")
    public String testRest() {
        RestTemplate restTemplate=new RestTemplate() ;
        //通过RestTemplate 的 getF orObject（）方法可 以获取 https: //www.baidu.com/的 网页 Html 代码，并在 API
        //接口“／testRest ’p 返回该网页的 Html 字符串
        return restTemplate.getForObject ("https://www.baidu.com/", String.class) ;
    }
}   