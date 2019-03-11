package com.bobo.learn.jaxws.service;

import javax.jws.WebService;

@WebService
public interface HelloService {

    public String sayHello(String name);
}
