package com.bobo.springcloud.learn.configservermultipledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerMultipleDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMultipleDemoApplication.class, args);
    }

}
