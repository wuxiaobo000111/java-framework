package com.bobo.springcloud.learn.skywalkingeurekaserverb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SkywalkingEurekaServerBApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkywalkingEurekaServerBApplication.class, args);
    }

}
