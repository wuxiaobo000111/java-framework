package com.bobo.rocketmq.quickstart;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * 生产者
 * @create 2019-01-20 11:52
 **/
public class Producer {

    public static void main(String[] args) throws Exception {
        //
        DefaultMQProducer producer = new DefaultMQProducer("quickstart_producer");
        // 指定nameServer地址
        producer.setNamesrvAddr("192.168.192.10:9876;192.168.192.11:9876");
        // 设置当发送失败的时候重试发送的次数
        producer.setRetryTimesWhenSendFailed(10);
        producer.start();
        for (int i=0; i<1;i++) {
            Message message = new Message("TopicQuickStart","TagA",
                    ("Hello Rcoketmq"+i).getBytes());
            SendResult send = producer.send(message);
            System.out.println(JSONObject.toJSONString(send));
        }
        producer.shutdown();
    }
}
