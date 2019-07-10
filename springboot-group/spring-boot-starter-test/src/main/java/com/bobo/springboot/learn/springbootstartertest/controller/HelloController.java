package com.bobo.springboot.learn.springbootstartertest.controller;

import com.bobo.springboot.learn.springbootstarterdemo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    private HelloService helloService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloService.sayHello(name);
    }

    @GetMapping("/info")
    public String info() {
        return helloService.helloWorld();
    }
}
