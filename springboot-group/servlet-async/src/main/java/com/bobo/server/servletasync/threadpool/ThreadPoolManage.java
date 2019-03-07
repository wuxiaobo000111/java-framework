package com.bobo.server.servletasync.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2019-03-06 22:01
 **/
public class ThreadPoolManage implements InitializingBean, DisposableBean {

    @Autowired
    private ThreadPoolFactory threadPoolFactory;

    private Logger logger = LoggerFactory.getLogger(ThreadPoolManage.class);

    private  Map<String,ControllerExecutorService> threadPoolExecutorMap = new ConcurrentHashMap<>();

    public ThreadPoolManage () {
        super();
    }

    public ControllerExecutorService getExecutorService(String methodName) {
        if (this.threadPoolExecutorMap.size() >0 && this.threadPoolExecutorMap.containsKey(methodName)) {
            return this.threadPoolExecutorMap.get(methodName);
        }
        return  threadPoolExecutorMap.put(methodName, threadPoolFactory.createThreadPool(methodName));
    }
    @Override
    public void destroy() throws Exception {
        shutdownAll();
    }

    /**
     * 关闭所有的线程池
     */
    private void shutdownAll() {
        logger.info("shutdown all threadPool");
        if (!threadPoolExecutorMap.isEmpty() && threadPoolExecutorMap.size() > 0) {
            Set<String> strings = threadPoolExecutorMap.keySet();
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                ControllerExecutorService controllerExecutorService = threadPoolExecutorMap.get(key);
                controllerExecutorService.shutDown();
            }
            threadPoolExecutorMap.clear();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //todo 暂时留下，可以做一些监控什么的，可以在这里初始化
    }
}
