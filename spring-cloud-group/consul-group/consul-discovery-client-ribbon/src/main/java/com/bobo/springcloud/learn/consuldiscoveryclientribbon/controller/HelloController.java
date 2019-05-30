package com.bobo.springcloud.learn.consuldiscoveryclientribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        String object = restTemplate.getForObject("http://consule-discovery-server-tag/hello?name=" + name, String.class);
        return object;
    }
}
