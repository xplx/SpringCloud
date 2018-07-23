package com.example.comsumer.controller.getConfig;

import com.example.comsumer.bean.ConfigBean;
import com.example.comsumer.bean.MyTestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @create 2018-07-12 10:09
 **/
@RestController
//加上@EnableConfigurationProperties 注解，并指明 ConfigBean 类，可以同时写上多个类
@EnableConfigurationProperties({MyTestBean.class, ConfigBean.class})
public class GetMyTestBeanController {
    @Autowired
    MyTestBean myTestBean;
    @RequestMapping("/getMyTestBean")
    public String getMyTestBean(){
        return myTestBean.toString();
    }
}   