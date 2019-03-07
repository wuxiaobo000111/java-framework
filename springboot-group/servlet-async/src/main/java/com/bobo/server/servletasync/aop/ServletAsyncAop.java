package com.bobo.server.servletasync.aop;

import com.alibaba.fastjson.JSONObject;
import com.bobo.server.servletasync.threadpool.ThreadPoolManage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;

/**
 * @author wuxiaobo@didachuxing.com
 * @create 2019-03-07 10:00
 **/

@Component
@Aspect
@Order(50)
public class ServletAsyncAop {

    private Logger logger = LoggerFactory.getLogger(ServletAsyncAop.class);

    @Autowired
    private ThreadPoolManage threadPoolManage;

    @Around(value = "execution (* com.bobo..*.controller..*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().getName();
        String name = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        String threadPoolName = className.concat(".").concat(name);
        logger.info("className:{},methodName:{},args:{}",className,name,JSONObject.toJSON(args));
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        AsyncContext asyncContext = request.startAsync();
        threadPoolManage.getExecutorService(threadPoolName).execute(request, new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                try {
                    Object proceed = pjp.proceed(args);
                    return proceed;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                return null;
            }
        });
        return null;
    }
}
