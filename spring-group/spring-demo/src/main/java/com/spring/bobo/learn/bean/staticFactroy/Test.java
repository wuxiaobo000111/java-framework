package com.spring.bobo.learn.bean.staticFactroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("staticFactory.xml");
        Dog dog = (Dog) context.getBean("dog");
        dog.testBeing();
    }
}
