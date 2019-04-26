package com.bobo.learn.jaxws.service.main;

import com.bobo.learn.jaxws.service.impl.HelloServiceImpl;
import org.apache.cxf.bus.blueprint.BlueprintBus;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * @create 2019-03-11 22:19
 **/
public class Server {

    public static void main(String[] args) {
        // 发布服务的工厂
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setAddress("http://localhost:10000/ws/hello");
        factoryBean.setServiceBean(new HelloServiceImpl());
        factoryBean.getInInterceptors().add((new LoggingInInterceptor()));
        factoryBean.getOutFaultInterceptors().add(new LoggingOutInterceptor());
        // 发布服务
        factoryBean.create();
        System.out.println("发布服务成功");
    }
}
