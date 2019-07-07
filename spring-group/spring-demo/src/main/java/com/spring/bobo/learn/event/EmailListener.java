package com.spring.bobo.learn.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EmailListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof EmailEvent) {
            EmailEvent emailEvent = (EmailEvent) event;
            System.out.println("邮件的接受地址是:"+emailEvent.getAddress());
            System.out.println("邮件的内容是:"+emailEvent.getText());
        }
    }
}
