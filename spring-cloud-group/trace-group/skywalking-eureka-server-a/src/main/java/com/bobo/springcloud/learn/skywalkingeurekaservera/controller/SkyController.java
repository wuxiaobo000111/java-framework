package com.bobo.springcloud.learn.skywalkingeurekaservera.controller;


import com.bobo.springcloud.learn.skywalkingeurekaservera.service.SkyFeignSerivece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkyController {

    @Autowired
    private SkyFeignSerivece skyFeignSerivece;

    @GetMapping(value = "/hello")
    public String getInfo(@RequestParam String name){

        return skyFeignSerivece.hello(name);
    }
}
