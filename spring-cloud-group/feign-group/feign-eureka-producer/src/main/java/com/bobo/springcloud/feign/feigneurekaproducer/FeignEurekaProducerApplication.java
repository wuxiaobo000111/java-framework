package com.bobo.springcloud.feign.feigneurekaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignEurekaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignEurekaProducerApplication.class, args);
    }

}
