package com.bobo.springcloud.learn.hystrixeurekathread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixEurekaThreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixEurekaThreadApplication.class, args);
    }

}
