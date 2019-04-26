package com.bobo.learn.jaxws.service;

import javax.jws.WebService;

/**
 * @create 2019-03-11 22:17
 **/
@WebService
public interface HelloService {


    public String sayHello(String name);
}
