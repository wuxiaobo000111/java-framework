package com.bobo.springcloud.feign.feigneurekamanyparamsconsumer.service;


import com.bobo.springcloud.feign.feigneurekamanyparamsconsumer.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "feign-eureka-many-params-producer")
public interface UserFeignService {

    @RequestMapping(value = "/user/add", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String addUser(@RequestParam("user") User user);

    @RequestMapping(value = "/user/update", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public String updateUser(@RequestBody User user);

}
