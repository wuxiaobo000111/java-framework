package com.bobo.springcloud.learn.hystrixeurekathread.controller;

import com.bobo.springcloud.learn.hystrixeurekathread.service.ThreadContextSyncService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;
import rx.Observer;

/**
 * @author wuxiaobo
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        final String[] result = {""};
        ThreadContextSyncService threadContextSyncService = new ThreadContextSyncService(name);
        Observable<String> observe = threadContextSyncService.observe();
        observe.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("聚合完了所有的查询请求!");
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                System.out.println("hello result =" +s);
            }
        });
        return "success";
    }
}
