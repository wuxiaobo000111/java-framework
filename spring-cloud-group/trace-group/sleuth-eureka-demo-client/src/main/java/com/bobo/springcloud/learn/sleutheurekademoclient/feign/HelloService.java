package com.bobo.springcloud.learn.sleutheurekademoclient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wuxiaobo
 */
@FeignClient(name = "sleuth-eureka-demo-server", configuration = FeignConfig.class)
public interface HelloService {

    /**
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    String hello(@RequestParam("name") String name);

}