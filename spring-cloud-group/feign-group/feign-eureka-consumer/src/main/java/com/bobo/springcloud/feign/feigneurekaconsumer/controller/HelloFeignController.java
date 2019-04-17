package com.bobo.springcloud.feign.feigneurekaconsumer.controller;


import com.bobo.springcloud.feign.feigneurekaconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloFeignController {

    @Autowired
    private HelloService helloService;

    // 服务消费者对位提供的服务
    @GetMapping(value = "/name")
    public String sayHello(@RequestParam("name") String name) {
        return helloService.searchRepo(name);
    }

}
