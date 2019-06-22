package com.bobo.springcloud.learn.gatewayeurekagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayEurekaGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayEurekaGatewayApplication.class, args);
    }

}
