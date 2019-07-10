package com.bobo.springboot.learn.springbootstarterdemo.config;

import com.bobo.springboot.learn.springbootstarterdemo.properties.HelloProperties;
import com.bobo.springboot.learn.springbootstarterdemo.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    private final HelloProperties helloProperties;

    public HelloServiceAutoConfiguration(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public HelloService helloService() {
        return new HelloService(this.helloProperties.getName(),
                this.helloProperties.getAge(),
                this.helloProperties.getHometown());
    }
}