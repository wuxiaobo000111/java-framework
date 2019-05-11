package com.bobo.springcloud.learn.hystrixeurekacache.service;

import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;

public interface IHelloService {
	String hello(Integer id);
	String getUserToCommandKey(@CacheKey Integer id);
	String updateUser(@CacheKey Integer id);
}
