package com.bobo.springcloud.learn.zuuleurekagrayzuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulEurekaGrayZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulEurekaGrayZuulServerApplication.class, args);
    }

}
