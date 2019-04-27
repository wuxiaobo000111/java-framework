package com.bobo.springcloud.learn.feigneurekahystrixproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignEurekaHystrixProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignEurekaHystrixProducerApplication.class, args);
    }

}
