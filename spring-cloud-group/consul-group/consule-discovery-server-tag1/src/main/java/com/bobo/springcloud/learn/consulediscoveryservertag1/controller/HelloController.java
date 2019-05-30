package com.bobo.springcloud.learn.consulediscoveryservertag1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping(value = "/hello")
    public String hello (@RequestParam String name) {
        return name+" hello";
    }
}
