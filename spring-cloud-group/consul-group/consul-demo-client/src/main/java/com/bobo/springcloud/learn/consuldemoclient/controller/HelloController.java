package com.bobo.springcloud.learn.consuldemoclient.controller;

import com.bobo.springcloud.learn.consuldemoclient.feign.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public String hello (String name ) {
        return helloService.sayHello(name);
    }
}
