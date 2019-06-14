package com.bobo.springcloud.learn.swaggerservertwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SwaggerServerTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerServerTwoApplication.class, args);
    }

}
