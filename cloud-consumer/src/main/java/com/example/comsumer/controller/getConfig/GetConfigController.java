package com.example.comsumer.controller.getConfig;

/**
 * @author wuxiaopeng
 * @create 2018-07-12 9:41
 **/

import com.example.comsumer.bean.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//加上@EnableConfigurationProperties 注解，并指明 ConfigBean 类
@EnableConfigurationProperties({ConfigBean.class})
public class GetConfigController {
    @Autowired
    private ConfigBean configBean;

    @RequestMapping(value = "/getConfig")
    public String getConfigBean(){
        return configBean.toString();
    }
}   