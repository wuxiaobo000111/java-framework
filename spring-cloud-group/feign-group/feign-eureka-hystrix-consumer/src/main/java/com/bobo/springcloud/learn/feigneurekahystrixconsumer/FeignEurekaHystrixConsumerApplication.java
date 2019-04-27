package com.bobo.springcloud.learn.feigneurekahystrixconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients
public class FeignEurekaHystrixConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignEurekaHystrixConsumerApplication.class, args);
    }

}
