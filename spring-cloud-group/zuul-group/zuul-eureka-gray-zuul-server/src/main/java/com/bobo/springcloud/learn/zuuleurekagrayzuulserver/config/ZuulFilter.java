package com.bobo.springcloud.learn.zuuleurekagrayzuulserver.config;

import com.bobo.springcloud.learn.zuuleurekagrayzuulserver.filter.GrayFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulFilter {

    @Bean
    public GrayFilter grayFilter () {
        return new GrayFilter();
    }
}
