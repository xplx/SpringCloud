package com.example.springBootDemo.controller;

import com.example.springBootDemo.domain.User;
import com.example.springBootDemo.service.NeoProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @create 2018-05-28 18:14
 **/
@RestController
public class GetUserController {
    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setUserName("小明");
        user.setUserPassword("xxxx");
        NeoProperties neoProperties = new NeoProperties();
        System.out.println(neoProperties.getDescription());
        return user;
    }
}   