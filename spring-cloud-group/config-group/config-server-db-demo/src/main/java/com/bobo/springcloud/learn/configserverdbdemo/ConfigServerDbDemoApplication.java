package com.bobo.springcloud.learn.configserverdbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerDbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerDbDemoApplication.class, args);
    }

}
