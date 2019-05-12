package com.bobo.springcloud.learn.ribboneurekademoconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/hello")
    public String hello (String name) {
        return restTemplate.getForObject("http://RIBBON-EUREKA-DEMO-PRODUCER/hello?name="+name,String.class);
    }
}
