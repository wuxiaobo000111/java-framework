package com.bobo.springcloud.learn.zuuleurekaserverdemo.config;

import com.bobo.springcloud.learn.zuuleurekaserverdemo.filter.FirstPreFilter;
import com.bobo.springcloud.learn.zuuleurekaserverdemo.filter.SecondPreFilter;
import com.bobo.springcloud.learn.zuuleurekaserverdemo.filter.ThirdPreFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulFilterConfig {

    @Bean
    public FirstPreFilter firstPreFilter () {
        return new FirstPreFilter();
    }

    @Bean
    public SecondPreFilter secondPreFilter () {
        return new SecondPreFilter();
    }

    @Bean
    public ThirdPreFilter thirdPreFilter () {
        return new ThirdPreFilter();
    }
}
