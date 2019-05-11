package com.bobo.springcloud.learn.hystrixeurekacollasper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
public class HystrixEurekaCollasperApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixEurekaCollasperApplication.class, args);
    }

}
