package com.bobo.springcloud.learn.hystrixeurekaturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableTurbine
public class HystrixEurekaTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixEurekaTurbineApplication.class, args);
    }

}
