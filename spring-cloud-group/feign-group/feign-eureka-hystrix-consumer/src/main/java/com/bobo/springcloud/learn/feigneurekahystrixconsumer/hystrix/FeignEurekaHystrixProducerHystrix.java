package com.bobo.springcloud.learn.feigneurekahystrixconsumer.hystrix;

import com.bobo.springcloud.learn.feigneurekahystrixconsumer.feign.FeignEurekaHystrixProducer;
import org.springframework.stereotype.Component;

@Component
public class FeignEurekaHystrixProducerHystrix implements FeignEurekaHystrixProducer {
    @Override
    public String hello(String name) {
        return "error";
    }
}
