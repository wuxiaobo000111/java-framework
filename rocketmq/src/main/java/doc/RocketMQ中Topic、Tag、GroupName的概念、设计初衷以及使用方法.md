
### topic

>Topic是生产者在发送消息和消费者在拉取消息的类别。Topic与生产者和消费者之间的关系非常松散。具体来说，一个Topic可能有0个，一个或多个生产者向它发送消息；相反，一个生产者可以发送不同类型Topic的消息。类似的，消费者组可以订阅一个或多个主题，只要该组的实例保持其订阅一致即可。

> Topic在Google翻译中解释为话题。我们可以理解为第一级消息类型，类比于书的标题。在应用系统中，一个Topic标识为一类消息类型，比如交易信息。

```java
 在Producer中使用Topic：

Message msg = new Message("TopicTest" /* Topic */,
                    "TagA",("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
   在Consumer中订阅Topic：

consumer.subscribe("TopicTest", "*");
```

### tag

>标签，换句话的意思就是子主题，为用户提供了额外的灵活性。有了标签，来自同一业务模块的具有不同目的的消息可以具有相同的主题和不同的标记。标签有助于保持代码的清晰和连贯，同时标签也方便RocketMQ提供的查询功能。

> Tag在Google翻译中解释为标签。我们可以理解为第二级消息类型，类比于书的目录，方便检索使用消息。在应用系统中，一个Tag标识为一类消息中的二级分类，比如交易信息下的交易创建、交易完成。

```java
 在Producer中使用Tag：

Message msg = new Message("TopicTest",
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
  在Consumer中订阅Tag：

consumer.subscribe("TopicTest", "TagA||TagB");// * 代表订阅Topic下的所有消息


```

### GroupName

> 和现实世界中一样，RocketMQ中也有组的概念。代表具有相同角色的生产者组合或消费者组合，称为生产者组或消费者组。

>作用是在集群HA的情况下，一个生产者down之后，本地事务回滚后，可以继续联系该组下的另外一个生产者实例，不至于导致业务走不下去。在消费者组中，可以实现消息消费的负载均衡和消息容错目标。
 
>另外，有了GroupName，在集群下，动态扩展容量很方便。只需要在新加的机器中，配置相同的GroupName。启动后，就立即能加入到所在的群组中，参与消息生产或消费。

```java
 在Producer中使用GroupName：

DefaultMQProducer producer = new DefaultMQProducer("group_name_1");// 使用GroupName来初始化Producer，如果不指定，就会使用默认的名字：DEFAULT_PRODUCER

DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group_name_1");// 使用GroupName来初始化Consumer，如果不指定，就会使用默认的名字：DEFAULT_CONSUMER
```