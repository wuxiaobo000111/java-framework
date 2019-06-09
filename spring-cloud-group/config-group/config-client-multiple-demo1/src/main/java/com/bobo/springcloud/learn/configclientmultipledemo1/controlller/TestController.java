package com.bobo.springcloud.learn.configclientmultipledemo1.controlller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${com.bobo.config.special}")
    private String value;


    @GetMapping("/getConfig")
    public String getUser() throws Exception{
        return value;
    }
}
