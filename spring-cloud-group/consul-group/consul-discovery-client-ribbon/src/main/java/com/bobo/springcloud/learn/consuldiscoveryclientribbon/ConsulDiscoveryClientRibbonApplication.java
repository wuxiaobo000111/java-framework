package com.bobo.springcloud.learn.consuldiscoveryclientribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsulDiscoveryClientRibbonApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsulDiscoveryClientRibbonApplication.class, args);
    }

}
