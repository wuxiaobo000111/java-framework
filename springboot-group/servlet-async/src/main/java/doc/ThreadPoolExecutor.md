### 来自于《java性能优化》 葛一鸣版
 ### ThreadPoolExecutor 
    public ThreadPoolExecutor (
                int corePoolsize,
                int maximumPoolSize,
                1ong keepAliveTime,
                TimeUnit unit,
                BlockingQueue<Runnable> workQueue,
                ThreadFactory  threadFactory,
                RejectedExecutionHandler handler)
    函数的参数含义如下:.
        corePoolSize:指定了线程池中的线程数量。
        maximumPoolSize:指定了线程池的最大线程数量。
        keepAliveTime当线程池线程数量超过corePoolSize时
        ,多余的空闲线程的存活时间。即,超过corePoolSize的空闲线程,在多长时间内会被销毁。
        unit: keepAliveTime的单位。
        workQueue:任务队列,被提交但尚未被执行的任务
        threadFactory:线程工厂,用于创建线程,一般用默认的即可
        handler:拒绝策略。当任务太多来不及处理,如何拒绝任务。以上参数中,大部分都很简单,只有workQueue和handler需要进行详细说明
### 任务对列
    参数workQueue指被提交但未执行的任务队列,它是一个BlockingQueue接口的对象,:仅用于在放Runnable对象。根据队列功能分类,在Thread
    PoolExecutor的构造函数中可使,,用以下几种BlockingQueue:"
	     直接提交的对列:该功能由SynchronousQueue对象提供。SynchronousQueue是个特殊的BlockingQueue.,SynchronousQueue没有容
	        量,每一个插入操作都要等待.一个相应的删除操作,反之,每一个删除操作都要等待对应的插入操作。
    	    SynchronousQueue不保存任务,它总是将任务提交给线程执行,如果没有空闲的,进程,则尝试创建新的进程,如果进程数量已经达到最天值,则执行拒绝策略。
    	    因此,使用SynchronousQueue队列,通常要设置很大的-maximumPoolSize值,否则很容易执行异常策略
	     有界的任务队列:有界的任务队列可以使用ArrayBlockingQueue实现。;
	        ArrayBlockingQueue的构造函数必须带一个容量参数,表示该队列的最大容量:public ArrayBlockingQueue (int capacity)
	        ,当使用有界的任务队列时,若有新的任务需要执行,如果线程池的实际线程数小于.corePoolSize,则会优先创建新的线程,若大于corePoolSize,则会将新任务加入等待对列。若等待队
	        列已满,无法加入,则在总线程数不大于maximumPoolSize的前
	        提下,创建新的进程执行任务。若大于maximumPoolSize,则执行拒绝策略。可见,有界队列仅当任务队列装满时,才可能将
	        线程数提升到corePoolSize以上,换言之,除非系统非常繁忙,否则确保核心线程数维持在corePoolSize.
	     无界的任务队列:
	        无界任务队列可以通过LinkedBlockingQueue类实现。与有界队列相比,除非系统资源耗尽,否则无界的任务队列
	        不存在任务入队失败的情况。当有新的住务到来,系统的线程数
	        小于corePoolSize时,线程池会生成新的线程执行任务,但当系统的线程数达到corePoolSize后,就不会继续增加。若后续仍有:的
	        任务加入,而又没有空闲的线程资源,则任务直接进入队列等待。若任务创建..和处理的速度差异很大,无界队列会保持快速增长,直到耗尽系统内存。
         优先任务队列:
            优先任务队列是带有执行优先级的队列,它通过PriorityBlockingQueue实现。可以控制任务的执行先后顺序,是一个特殊的无
            界队列。无论是有界队列ArrayBlockingQueue,还是未指定大小的无界队列LinkedBlockingQueue都是按照先进先出算法处理任
            的。而PriorityBlockingQueue则可以根据任务自身的优先级顺序先后执行,在确保系统性能的同时,也能有很好的质量保证
            (总是确保高优先级的任务先执行)。
### 拒绝策略
    JDK内置的拒维策略如下:
        AbortPolicy策略:该策略会直接抛出异常,阻止系统正常工作。
        CallerRunsPolicy策略:只要线程池未关闭,该策略直接在调用者线程中,运行当前被丢弃的任务。
        DiscardOledestPolicy策略:该策略将丢弃最老的一个请求,也就是即将被执行的幽一个任务,并尝试再次提交当前任务。
        DiscardPolicy策略:该策略默默地丢弃无法处理的任务,不予任何处理。  
        以上内置的策略均实现了RejectedExecutionHandler接口,若以 策略仍无法满足实际,应用需要,完全可以自己扩展RejectedExecutionHandler RejectedExecutionHandler的定义如下

