package com.bobo.springcloud.learn.hystrixeurekaexception.controller;

import com.bobo.springcloud.learn.hystrixeurekaexception.service.FallbackBadRequestExpcetionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    private Logger logger = LoggerFactory.getLogger(ExceptionController.class);


    @GetMapping("/getPSFallbackBadRequestExpcetion")
    public String providerServiceFallback(){
        String result = new FallbackBadRequestExpcetionService().execute();
        return result;
    }


    @GetMapping("/getFallbackMethodTest")
    @HystrixCommand
    public String getFallbackMethodTest(String id){
        throw new RuntimeException("getFallbackMethodTest failed");
    }

    public String fallback(String id, Throwable throwable) {
        logger.error(throwable.getMessage());
        return "this is fallback message";
    }

}
