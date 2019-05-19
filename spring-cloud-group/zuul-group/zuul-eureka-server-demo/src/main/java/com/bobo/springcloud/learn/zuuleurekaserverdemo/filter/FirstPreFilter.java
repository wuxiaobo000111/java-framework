package com.bobo.springcloud.learn.zuuleurekaserverdemo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

public class FirstPreFilter extends ZuulFilter {

    /**
     * Filter的类型
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * Filter的执行次序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 使用返回值来设置该Filter是否执行。可以作为开关来使用
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("hello, I am First Zuul Filter");
        return null;
    }
}
