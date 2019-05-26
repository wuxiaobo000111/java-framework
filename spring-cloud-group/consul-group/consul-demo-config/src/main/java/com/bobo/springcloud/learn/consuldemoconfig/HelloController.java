package com.bobo.springcloud.learn.consuldemoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // 读取远程配置
    @Value("${name}")
    private String name;

    @GetMapping(value = "/getName")
    public String getName  () {
        return name;
    }

}
