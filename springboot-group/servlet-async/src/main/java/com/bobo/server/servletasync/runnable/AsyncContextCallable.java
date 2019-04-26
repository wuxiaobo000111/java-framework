package com.bobo.server.servletasync.runnable;

import javax.servlet.AsyncContext;
import java.util.concurrent.Callable;

/**
 * @create 2019-03-06 23:18
 **/
public abstract class AsyncContextCallable implements Runnable {
    private AsyncContext asyncContext;

    public AsyncContext getAsyncContext() {
        return asyncContext;
    }

    public AsyncContextCallable (AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }
}
