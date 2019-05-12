package com.bobo.springcloud.learn.ribboneurekademoconsumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 指定ribbon的负载均衡策略
 */
@Configuration
@AvoidScan
public class RibbonRuleConfig {

    @Autowired
    IClientConfig config;

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();
    }
}
