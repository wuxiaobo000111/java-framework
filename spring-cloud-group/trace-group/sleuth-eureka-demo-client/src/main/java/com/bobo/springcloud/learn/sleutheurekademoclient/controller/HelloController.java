package com.bobo.springcloud.learn.sleutheurekademoclient.controller;

import com.bobo.springcloud.learn.sleutheurekademoclient.feign.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private HelloService helloService;

    @Autowired
    private ExecutorService executorService;

    @GetMapping(value = "/name")
    public String hello(@RequestParam String name) throws Exception {
        Future future = executorService.submit(() -> {
            log.info("client sent. 进入子线程, 参数: {}",name);
            String result = helloService.hello(name);
            return result;
        });
        String result = (String) future.get();
        log.info("client received. 返回主线程, 结果: {}",result);
        return result;
    }
}
