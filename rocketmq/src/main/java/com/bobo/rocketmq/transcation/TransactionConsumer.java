package com.bobo.rocketmq.transcation;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.bobo.rocketmq.constants.Constants;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * 带有事务的消费者
 * @author wuxiaobo@didachuxing.com
 * @create 2019-01-26 17:43
 **/
public class TransactionConsumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("transaction_consumer");
        consumer.setNamesrvAddr(Constants.ROCKETMQ_ADDR);
        consumer.subscribe("topicTransaction","*");
        consumer.registerMessageListener(new MyMessageListener());
        consumer.start();
    }
}
class MyMessageListener implements MessageListenerConcurrently {


    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        for (MessageExt messageExt : msgs) {
            String topic = messageExt.getTopic();
            String body  = new String(messageExt.getBody(),CharsetUtil.UTF_8);
            String tags = messageExt.getTags();
            System.out.println("收到的消息:"+"   topic: "+topic+", tags:" +tags+", body:" +body);
        }
        // 处理业务逻辑，返回成功
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
