package com.bobo.server.servletasync.listener;

import com.alibaba.fastjson.JSON;
import com.bobo.server.servletasync.common.ServletUtil;
import com.boob.servlet.common.ReplyMap;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;
import java.util.Map;

/**
 * @create 2019-03-06 22:45
 **/
@Slf4j
public class ServletAsyncListener implements AsyncListener {
    @Override
    public void onComplete(AsyncEvent asyncEvent) throws IOException {

    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        AsyncContext asyncContext = asyncEvent.getAsyncContext();
        responseError(asyncContext,"server time out");
    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException {
        AsyncContext asyncContext = asyncEvent.getAsyncContext();
        responseError(asyncContext,"server error");
    }

    /**
     *  异步线程开始时，调用AsyncListener的onStartAsync(AsyncEvent event)方法；
     * @param asyncEvent
     * @throws IOException
     */
    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {

    }


    private void responseError(AsyncContext asyncContext, String reason) {
        String uri = "";
        Map params = null;
        try {
            uri = (String) asyncContext.getRequest().getAttribute("uri");
            params = (Map) asyncContext.getRequest().getAttribute("params");
            log.error("async request {}, uri : {}, params : {}", reason, uri, JSON.toJSONString(params));
        } catch (Exception e) {
            log.error("responseError failed.", e);
        }

        ServletUtil.doResponse(asyncContext, new ReplyMap().busy().toJson(), uri, params);
    }
}
