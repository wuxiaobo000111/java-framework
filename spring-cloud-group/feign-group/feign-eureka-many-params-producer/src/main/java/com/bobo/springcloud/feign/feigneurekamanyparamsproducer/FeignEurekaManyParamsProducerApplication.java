package com.bobo.springcloud.feign.feigneurekamanyparamsproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignEurekaManyParamsProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignEurekaManyParamsProducerApplication.class, args);
    }

}
