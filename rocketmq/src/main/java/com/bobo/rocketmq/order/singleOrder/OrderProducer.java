package com.bobo.rocketmq.order.singleOrder;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.bobo.rocketmq.constants.Constants;

import java.util.List;

/**
 * 顺序消费生产者
 * @create 2019-01-26 14:48
 **/
public class OrderProducer {

    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {

        DefaultMQProducer producer = new DefaultMQProducer("order_producer");
        producer.setNamesrvAddr(Constants.ROCKETMQ_ADDR);
        producer.start();

        for (int i=0; i<5; i++) {
            Message msg = new Message("TopicOrderTest", "order_1", "KEY" + i, ("order_1 " + i).getBytes());

            SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id = (Integer) arg;
                    int index = id % mqs.size();
                    return mqs.get(index);
                }
            }, 0);

            System.out.println(sendResult);
        }

        producer.shutdown();
    }
}
