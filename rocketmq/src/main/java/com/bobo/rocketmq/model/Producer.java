package com.bobo.rocketmq.model;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.bobo.rocketmq.constants.Constants;

/**
 * 生产者
 * @create 2019-01-21 19:39
 **/
public class Producer {

    public static void main(String[] args) throws Exception {
        String groupName = "message_producer";

        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(Constants.ROCKETMQ_ADDR);
        producer.start();
        for (int i =0; i<= 100; i++){
            Message message = new Message("Topic1","Tag1",("信息内容"+i).getBytes());
            SendResult send = producer.send(message);
            System.out.println(JSONObject.toJSONString(send));
        }
        producer.shutdown();
    }
}
