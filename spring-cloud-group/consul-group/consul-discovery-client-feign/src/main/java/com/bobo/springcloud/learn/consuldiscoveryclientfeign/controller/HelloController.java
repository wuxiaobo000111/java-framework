package com.bobo.springcloud.learn.consuldiscoveryclientfeign.controller;

import com.bobo.springcloud.learn.consuldiscoveryclientfeign.feign.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return helloService.hello(name);
    }
}
