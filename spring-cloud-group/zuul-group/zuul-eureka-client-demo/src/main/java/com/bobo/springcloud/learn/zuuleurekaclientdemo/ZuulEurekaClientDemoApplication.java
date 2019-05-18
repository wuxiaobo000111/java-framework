package com.bobo.springcloud.learn.zuuleurekaclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZuulEurekaClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulEurekaClientDemoApplication.class, args);
    }

}
