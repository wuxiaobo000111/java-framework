package com.bobo.springcloud.learn.hystrixeurekaexception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient
@EnableHystrix
@SpringBootApplication
public class HystrixEurekaExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixEurekaExceptionApplication.class, args);
    }

}
