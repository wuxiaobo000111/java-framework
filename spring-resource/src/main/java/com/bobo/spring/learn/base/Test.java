package com.bobo.spring.learn.base;

import contomTaglib.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Test {

    public static void main(String[] args) throws Exception{

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mytest.xml");
        MyTestBean myTestBean = applicationContext.getBean("myTestBean", MyTestBean.class);
        System.out.println(myTestBean.getTestStr());














        /*    *//**
         * 	super();
         * 		ignoreDependencyInterface(BeanNameAware.class);
         * 		ignoreDependencyInterface(BeanFactoryAware.class);
         * 		ignoreDependencyInterface(BeanClassLoaderAware.class);
         *  XmlBeanFactory构造函数中移除了这三个接口
         *//*
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("mytest.xml"));
        MyTestBean bean = factory.getBean(MyTestBean.class);
        MyTestBean myTestBean = (MyTestBean) factory.getSingleton("myTestBean");
        System.out.println(myTestBean.getTestStr());
        Object singleton = factory.getSingleton("myTestBean", MyTestBean::new);*/
       /* SimpleDateFormat info = (SimpleDateFormat) factory.getBean("dateFormat");
        System.out.println(info.format(new Date()));*/


        /**
         * 反射代码
         */
        /*Class<User> loadClass = (Class<User>) Thread.currentThread().getContextClassLoader().loadClass("contomTaglib.User");
        User user = loadClass.newInstance();
        Method setUserName = loadClass.getMethod("setUserName", String.class);
        Method setEmail = loadClass.getMethod("setEmail", String.class);
        setEmail.invoke(user,"2244027504@qq.com");
        System.out.println(user.toString());*/



      /*  BeanDefinition myTestBean = factory.getBeanDefinition("myTestBean");
        String testStr = (String) myTestBean.getAttribute("testStr");
        System.out.println(testStr);*/
    }

}
