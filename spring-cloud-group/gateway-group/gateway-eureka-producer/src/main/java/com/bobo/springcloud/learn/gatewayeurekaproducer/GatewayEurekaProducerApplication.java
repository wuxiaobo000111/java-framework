package com.bobo.springcloud.learn.gatewayeurekaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayEurekaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayEurekaProducerApplication.class, args);
    }

}
