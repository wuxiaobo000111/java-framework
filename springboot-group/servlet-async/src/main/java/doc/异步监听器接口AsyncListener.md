
### 异步监听器接口AsyncListener
```text
Servlet 3.0为异步处理提供了一个监听器，使用AsyncListener接口表示。此接口负责管理异步事件，它可以监控如下四种事件：
1. 异步线程开始时，调用AsyncListener的onStartAsync(AsyncEvent event)方法； 
2. 异步线程出错时，调用AsyncListener的onError(AsyncEvent event)方法； 
3. 异步线程执行超时，则调用AsyncListener的onTimeout(AsyncEvent event)方法； 
4. 异步执行完毕时，调用AsyncListener的onComplete(AsyncEvent event)方法

```

>要注册一个AsyncListener，只需将准备好的AsyncListener对象传递给AsyncContext对象的addListener()方法即可，如下所示：



```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res){
    AsyncContext actx = req.startAsync();
    actx.addListener(new AsyncListener(){
        public void onComplete(AsyncEvent event) throws IOException{
            // do 一些清理工作或者其他
        }

        public void onTimeout(AsyncEvent event) throws IOException{
            // do 一些超时处理的工作或者其他
        }
    });
    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
    executor.execute(new MyAsyncService(actx));
}
```