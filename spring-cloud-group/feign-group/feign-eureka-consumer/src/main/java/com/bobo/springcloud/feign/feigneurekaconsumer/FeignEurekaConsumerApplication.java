package com.bobo.springcloud.feign.feigneurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class FeignEurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignEurekaConsumerApplication.class, args);
    }

}
