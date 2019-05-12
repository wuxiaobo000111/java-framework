package com.bobo.springcloud.learn.ribboneurekademoproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonEurekaDemoProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonEurekaDemoProducerApplication.class, args);
    }

}
