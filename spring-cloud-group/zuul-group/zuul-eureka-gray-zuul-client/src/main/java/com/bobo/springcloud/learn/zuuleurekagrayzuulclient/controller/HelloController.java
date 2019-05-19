package com.bobo.springcloud.learn.zuuleurekagrayzuulclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${service-flag}")
    private String serviceFlag;

    @GetMapping(value = "/hello")
    public String  hello (String name) {
        return "hello, "+ name+", service_flag:" + serviceFlag;
    }
}
