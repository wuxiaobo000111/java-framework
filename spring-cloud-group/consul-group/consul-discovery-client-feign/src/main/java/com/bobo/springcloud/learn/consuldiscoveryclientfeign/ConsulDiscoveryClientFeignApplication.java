package com.bobo.springcloud.learn.consuldiscoveryclientfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsulDiscoveryClientFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulDiscoveryClientFeignApplication.class, args);
    }

}
