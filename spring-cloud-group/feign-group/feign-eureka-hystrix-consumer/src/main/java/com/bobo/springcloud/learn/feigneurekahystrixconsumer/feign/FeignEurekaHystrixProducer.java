package com.bobo.springcloud.learn.feigneurekahystrixconsumer.feign;

import com.bobo.springcloud.learn.feigneurekahystrixconsumer.hystrix.FeignEurekaHystrixProducerHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "feign-eureka-hystrix-producer",fallback = FeignEurekaHystrixProducerHystrix.class)
public interface FeignEurekaHystrixProducer {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    String hello(@RequestParam(value = "name")String name);
}
