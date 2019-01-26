
### Producer分类

```text
1.NormalProducer(普通)
2.OrderProducer(顺序)
3.TranscationProducer(事务)
```
>顺序消费:produce在发送消息的时候，把消息发到同一个队列（queue）中,消费者注册消息监听器为MessageListenerOrderly，这样就可以保证消费端只有一个线程去消费消息
 注意：是把把消息发到同一个队列（queue），不是同一个topic，默认情况下一个topic包括4个queue