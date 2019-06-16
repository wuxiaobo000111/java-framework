package com.bobo.springcloud.learn.gatewayprodicatedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayProdicateDemoApplication {



    public static void main(String[] args) {
        SpringApplication.run(GatewayProdicateDemoApplication.class, args);
    }

}
