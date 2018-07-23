package com.example.cloudribbonconsumer.controller;

import com.example.cloudribbonconsumer.serverImp.RibbonServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @create 2018-07-13 14:23
 **/
@RestController
public class RibbonController {
    @Autowired
    RibbonServer ribbonServer;

    @GetMapping("/hello")
    public String hello(@RequestParam (required = false, defaultValue ="wuxiaopeng") String name)  {
        return ribbonServer.hi(name);
    }
}   