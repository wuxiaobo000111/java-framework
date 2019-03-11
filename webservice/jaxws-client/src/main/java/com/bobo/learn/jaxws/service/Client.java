package com.bobo.learn.jaxws.service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2019-03-11 23:09
 **/
public class Client {

    public static void main(String[] args) {
        // 创建CXF代理工厂
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setAddress("http://localhost:10000/ws/hello");
        // 接口类名必须和服务单包和类名保持一致，否则会报错
        factoryBean.setServiceClass(HelloService.class);
        HelloService helloService = factoryBean.create(HelloService.class);
        System.out.println(helloService.sayHello("wuxiaobo"));
    }
}
