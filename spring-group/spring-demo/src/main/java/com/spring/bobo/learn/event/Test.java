package com.spring.bobo.learn.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("event.xml");
        EmailEvent emailEvent  = new EmailEvent("test","1243@163.com","hello man");
        context.publishEvent(emailEvent);

    }
}
