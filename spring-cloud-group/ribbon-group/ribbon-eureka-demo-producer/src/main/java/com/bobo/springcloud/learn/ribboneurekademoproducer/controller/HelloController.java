package com.bobo.springcloud.learn.ribboneurekademoproducer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello (String name) {
        return "hello," + name;
    }
}
