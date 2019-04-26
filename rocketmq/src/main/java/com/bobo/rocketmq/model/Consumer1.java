package com.bobo.rocketmq.model;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import com.bobo.rocketmq.constants.Constants;
import io.netty.util.CharsetUtil;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 消费者1
 * @create 2019-01-21 19:44
 **/
public class Consumer1 {

    public static void main(String[] args) throws MQClientException {

        String groupName = "message_consumer";
        AtomicInteger integer = new AtomicInteger();
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(Constants.ROCKETMQ_ADDR);
        // 底层源码显示的过滤表达式是这个样子的  String[] tags = subString.split("\\|\\|");
        consumer.subscribe("Topic1","Tag1 || Tag2 || Tag3");
        // 设置消费的方式，是广播消费还是集群方式消费，模式人集群消费
       /* consumer.setMessageModel(MessageModel.CLUSTERING);*/
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
              try {
                  for (MessageExt messageExt : msgs) {
                      String topic = messageExt.getTopic();
                      String message = new String(messageExt.getBody(), CharsetUtil.UTF_8);
                      String tags = messageExt.getTags();
                      System.out.println(integer.addAndGet(1));
                      System.out.println("topic: " +topic+", tags:  "+tags+", message:  "+message);

                  }
              }catch (Exception e) {
                  e.printStackTrace();
                  return ConsumeConcurrentlyStatus.RECONSUME_LATER;
              }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("consumer1 start.......");
    }
}
