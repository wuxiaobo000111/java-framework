package com.bobo.springcloud.learn.consuldiscoveryclientfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "consule-discovery-server-tag",configuration = FeignConfig.class)
public interface HelloService {

    @GetMapping(value = "/hello")
    String hello(@RequestParam(value = "name") String name);

}
