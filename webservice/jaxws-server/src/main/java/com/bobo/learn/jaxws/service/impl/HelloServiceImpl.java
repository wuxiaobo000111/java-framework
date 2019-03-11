package com.bobo.learn.jaxws.service.impl;

import com.bobo.learn.jaxws.service.HelloService;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2019-03-11 22:18
 **/
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name+"hello world";
    }
}
