package com.bobo.springcloud.feign.feigneurekaconsumer.service;

import com.bobo.springcloud.feign.feigneurekaconsumer.config.HelloFeignServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuxiaobo
 */
@FeignClient(name = "feign-eureka-producer", configuration = HelloFeignServiceConfig.class)
public interface HelloService {

    /**
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    String searchRepo(@RequestParam("name") String name);

}
