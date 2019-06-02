package com.bobo.springcloud.learn.consulconfigcustomize.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 读取远程配置
    @Value("${foo.bar.name}")
    private String name;

    // 将配置展示在页面
    @GetMapping("/getName")
    public String getName(){
        return name;
    }
}
