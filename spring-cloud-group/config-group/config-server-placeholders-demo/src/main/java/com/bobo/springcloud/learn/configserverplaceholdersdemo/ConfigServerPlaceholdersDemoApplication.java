package com.bobo.springcloud.learn.configserverplaceholdersdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerPlaceholdersDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerPlaceholdersDemoApplication.class, args);
    }

}
