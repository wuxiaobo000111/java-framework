
### RocketMQ的负载均衡

>RocketMq是天然支持负载均衡的，也就是说，对于同一个topic来说，如果部署多个consumer，那么这些consumer能做到消费消费的时候不会重复消费。
示例代码如这个包中的代码所示，这个是结果。
>首先启动consuemr1和consumer2,然后启动Producer，可以看到结果如下所示:
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190121214750877.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1NDg0MTQ3,size_16,color_FFFFFF,t_70)![在这里插入图片描述](https://img-blog.csdnimg.cn/20190121214803423.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI1NDg0MTQ3,size_16,color_FFFFFF,t_70)

>这里注意一下，如果说是consumer1挂了,这个时候会尝试去发送给consumer2，会在消费者集群内部进行不断的尝试。

>如果先启动Producer,如果consumer是集群环境,会出现重复消费的问题哦，不要使用。(严重违规操作)

### 如何设置负载均衡策略
```java
 // 设置负载均衡策略
        AllocateMessageQueueAveragelyByCircle allocateMessageQueueAveragelyByCircle = new AllocateMessageQueueAveragelyByCircle();
        consumer.setAllocateMessageQueueStrategy(allocateMessageQueueAveragelyByCircle);
```
