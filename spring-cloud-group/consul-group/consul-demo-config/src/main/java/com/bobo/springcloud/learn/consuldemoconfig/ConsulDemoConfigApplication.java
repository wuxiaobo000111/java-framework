package com.bobo.springcloud.learn.consuldemoconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class ConsulDemoConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulDemoConfigApplication.class, args);
    }

}

