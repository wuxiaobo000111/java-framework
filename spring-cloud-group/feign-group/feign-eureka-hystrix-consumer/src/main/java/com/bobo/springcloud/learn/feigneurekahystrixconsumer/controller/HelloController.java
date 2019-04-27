package com.bobo.springcloud.learn.feigneurekahystrixconsumer.controller;

import com.bobo.springcloud.learn.feigneurekahystrixconsumer.feign.FeignEurekaHystrixProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private FeignEurekaHystrixProducer feignEurekaHystrixProducer;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(String name) {
        return feignEurekaHystrixProducer.hello(name);
    }
}
