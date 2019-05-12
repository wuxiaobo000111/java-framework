package com.bobo.springcloud.learn.hystrixeurekathread.Hystrix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixThreadContextConfiguration {
	@Bean
	public SpringCloudHystrixConcurrencyStrategy springCloudHystrixConcurrencyStrategy() {
		return new SpringCloudHystrixConcurrencyStrategy();
	}
}