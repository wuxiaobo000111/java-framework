package com.bobo.springcloud.learn.consuldiscoveryclientdiscoveryclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.CallbackHelper;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
public class HelloController {
    @Autowired  // ConsulDiscoveryClient 会在程序启动时,初始化为DiscoveryClient实例
    private DiscoveryClient discoveryClient;

    // 这里只举例获取服务方信息,不去请求服务方接口
    @GetMapping("/getServer")
    public List<ServiceInstance> getServer(String serviceId){
        return discoveryClient.getInstances(serviceId);
    }


    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        List<ServiceInstance> instances = discoveryClient.getInstances("consule-discovery-server-tag");
        RestTemplate restTemplate = new RestTemplate();
        if (instances != null && instances.size() > 0) {
            String serviceUri = instances.get(0).getUri().toString()+"/hello?name=" + name;
            ResponseEntity< String > restExchange =
                    restTemplate.exchange(
                            serviceUri,
                            HttpMethod.GET,
                            null, String.class);
            return restExchange.getBody();
        }
        return null;
    }

}
