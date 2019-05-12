package com.bobo.springcloud.learn.ribboneurekademoconsumer;

import com.bobo.springcloud.learn.ribboneurekademoconsumer.config.AvoidScan;
import com.bobo.springcloud.learn.ribboneurekademoconsumer.config.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "ribbon-eureka-demo-producer", configuration = RibbonRuleConfig.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {AvoidScan.class})})
public class RibbonEurekaDemoConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate () {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(RibbonEurekaDemoConsumerApplication.class, args);
    }

}
