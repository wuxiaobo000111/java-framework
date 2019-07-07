package com.spring.bobo.learn.bean.shiliFactory;

import com.spring.bobo.learn.bean.staticFactroy.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("shiliFactory.xml");
        Dog dog = (Dog) context.getBean("dog");
        dog.testBeing();
    }
}
