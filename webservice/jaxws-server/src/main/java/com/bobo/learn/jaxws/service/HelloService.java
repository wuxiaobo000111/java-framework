package com.bobo.learn.jaxws.service;

import javax.jws.WebService;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2019-03-11 22:17
 **/
@WebService
public interface HelloService {


    public String sayHello(String name);
}
