package com.bobo.springcloud.learn.hystrixeurekathread.service;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class ThreadContextSyncService extends HystrixObservableCommand<String> {

    @Autowired
    private RestTemplate restTemplate;

    private String name;

    public ThreadContextSyncService(String name) {
        // 调用父类构造方法
        super(HystrixCommandGroupKey.Factory.asKey("usercommand"));
        this.name = name;
    }

    @Override
    protected Observable<String> construct() {
       return Observable.create(new Observable.OnSubscribe<String>() {
           @Override
           public void call(Subscriber<? super String> subscriber) {
                try {
                    //伪造超时事件
                    Thread.sleep(10000);
                    String template = restTemplate.getForObject("http://FEIGN-EUREKA-HYSTRIX-PRODUCER/hello?name={1}",
                            String.class, name);
                    subscriber.onNext(template);
                    subscriber.onCompleted();
                }catch (Exception e) {
                    subscriber.onError(e);
                }
           }
       }).subscribeOn(Schedulers.io());
    }

    @Override
    protected Observable<String> resumeWithFallback() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    subscriber.onNext("error");
                    subscriber.onCompleted();
                }catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.io());
    }
}
