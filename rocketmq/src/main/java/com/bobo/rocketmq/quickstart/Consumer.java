package com.bobo.rocketmq.quickstart;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.bobo.rocketmq.constants.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 消费者
 * @create 2019-01-20 13:16
 **/
public class Consumer {

    private static AtomicInteger integer = new AtomicInteger();

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer  =new DefaultMQPushConsumer("quickstart_consumer");
        consumer.setNamesrvAddr(Constants.ROCKETMQ_ADDR);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe("TopicQuickStart","*");
        //设置一次消费多少条，默认情况下是一次消费一个消息,注意这里就算是设置了，也是消费一条消息
        // 只有当先启动producer的时候，这个设置才会生效
        // 一般启动方式是先启动consumer，然后再启动Producer
        consumer.setConsumeMessageBatchMaxSize(10);
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            // 消息是一条一条的消费的
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println("Receive New Message:" + msgs.size());
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}
