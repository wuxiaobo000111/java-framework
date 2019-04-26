package com.bobo.server.servletasync.threadpool;


import com.bobo.server.servletasync.common.ServletUtil;
import com.bobo.server.servletasync.listener.ServletAsyncListener;
import com.bobo.server.servletasync.runnable.AsyncContextCallable;
import com.boob.servlet.common.ReplyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @create 2019-03-06 21:41
 **/
public class ControllerExecutorService {

    private Logger logger = LoggerFactory.getLogger(ControllerExecutorService.class);

    private ThreadPoolExecutor executorService;

    private AsyncListener asyncListener;

    private AtomicInteger threadNumber = new AtomicInteger(0);

    private Integer corePoolSize;
    private Integer maximumPoolSize;
    private Integer keepAliveTime;
    private Integer blockingQueueCapacity;
    private String methodName;


    public ControllerExecutorService(Integer corePoolSize, Integer maximumPoolSize, Integer keepAliveTime,
                                     Integer blockingQueueCapacity, String method) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.blockingQueueCapacity = blockingQueueCapacity;
        this.methodName = method;
        //init threadPool
        initThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, blockingQueueCapacity);
    }

    private void initThreadPoolExecutor(Integer corePoolSize, Integer maximumPoolSize, Integer keepAliveTime,
                                        Integer blockingQueueCapacity) {
        executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(blockingQueueCapacity), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                thread.setName("servlet-async-" + methodName + threadNumber.getAndIncrement());
                return thread;
            }
        });
        executorService.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                if (r instanceof AsyncContextCallable) {
                    AsyncContextCallable asyncContextCallable = (AsyncContextCallable) r;
                    AsyncContext asyncContext = asyncContextCallable.getAsyncContext();
                    HttpServletRequest request = (HttpServletRequest) asyncContext.getRequest();
                    String requestURI = request.getRequestURI();
                    Map<String, String[]> parameterMap = request.getParameterMap();
                    ServletUtil.doResponse(asyncContext, new ReplyMap().fail().toJson(), requestURI, parameterMap);
                }
            }
        });
    }

    public void execute(HttpServletRequest request, Callable<Object> callable) throws Exception {
        AsyncContext asyncContext = request.getAsyncContext();
        String requestURI = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        asyncContext.getRequest().setAttribute("uri", requestURI);
        asyncContext.getRequest().setAttribute("params", parameterMap);
        if (this.asyncListener == null) {
            this.asyncListener = new ServletAsyncListener();
        }
        asyncContext.addListener(this.asyncListener);
        if (request.isAsyncStarted()) {
            executorService.execute(new AsyncContextCallable(asyncContext) {
                @Override
                public void run() {
                    Object o = null;
                    try {
                        o = callable.call();
                    } catch (Exception e) {
                        logger.error("service.call failed.", e);
                    }
                    if (o == null) {
                        logger.error("service.call return null");
                        o = new ReplyMap().fail().toJson();
                    } else if (o instanceof ReplyMap) {
                        o = ((ReplyMap) o).toJson();
                    }
                    ServletUtil.doResponse(asyncContext, o, requestURI, parameterMap);
                }
            });
        } else {
            ServletUtil.doResponse(asyncContext, new ReplyMap().busy().toJson(), requestURI, parameterMap);
        }

    }

    public void shutDown() {
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
