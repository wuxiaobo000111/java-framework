package com.bobo.server.servletasync.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2019-03-07 14:54
 **/

@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() throws InterruptedException {
        Thread.sleep(2000);
        return "hello";
    }
}
