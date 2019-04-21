package com.bobo.springcloud.feign.feignfileproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignFileProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignFileProducerApplication.class, args);
    }

}
