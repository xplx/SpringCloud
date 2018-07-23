package com.example.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @create 2018-07-20 15:38
 **/
@RestController
public class GetLocalConfigController {

    //@Value("${foo}")
    String foo;
    @RequestMapping(value = "/foo")
    public String hi(){
        return foo;
    }
}