package com.bobo.springcloud.learn.gatewaydemobyconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayDemoByConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayDemoByConfigApplication.class, args);
    }

}
