package com.example.springBootDemo.service;

import org.springframework.beans.factory.annotation.Value;

/**
 * 获取配置文件信息
 * @author wuxiaopeng
 * @create 2018-05-28 18:24
 **/

public class NeoProperties {
    @Value("${com.neo.title}")
    private String title;
    @Value("${com.neo.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}