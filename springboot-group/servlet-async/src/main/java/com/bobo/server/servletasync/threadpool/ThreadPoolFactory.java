package com.bobo.server.servletasync.threadpool;

import org.springframework.beans.factory.annotation.Value;


/**
 * 创建一个线程池
 *
 * @create 2019-03-06 21:17
 **/
public class ThreadPoolFactory {

    @Value("${threadpool.corePoolsize:10}")
    private String corePoolSize;

    @Value("${threadpool.maximumPoolSize:20}")
    private String maximumPoolSize;

    @Value("${threadpool.keepAliveTime:30}")
    private String keepAliveTime;

    @Value("${threadpool.blockingQueue.capacity}")
    private String blockingQueueCapacity;


    /**
     * 这个method名字限定为比如com.bobo.HelloController.sayHello这样形式的
     * @param method
     * @return
     */
    public ControllerExecutorService createThreadPool(String method) {

        ControllerExecutorService executorService = new ControllerExecutorService(Integer.parseInt(corePoolSize),
                Integer.parseInt(maximumPoolSize),Integer.parseInt(keepAliveTime),
                Integer.parseInt(blockingQueueCapacity),method);
        return executorService;
    }
}
