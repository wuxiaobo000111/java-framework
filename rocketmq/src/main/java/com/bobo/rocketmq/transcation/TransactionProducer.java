package com.bobo.rocketmq.transcation;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.client.producer.TransactionCheckListener;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;
import com.alibaba.rocketmq.client.producer.TransactionSendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.bobo.rocketmq.constants.Constants;

import java.util.concurrent.TimeUnit;

/**
 * 带有事务的生产者
 *
 * @create 2019-01-26 17:25
 **/
public class TransactionProducer {
    public static void main(String[] args) throws MQClientException, InterruptedException {

        TransactionMQProducer producer = new TransactionMQProducer("transcation_producer");

        producer.setNamesrvAddr(Constants.ROCKETMQ_ADDR);

        //事务回查最小并发数
        producer.setCheckThreadPoolMinSize(5);

        //事务会查最大并发数
        producer.setCheckThreadPoolMaxSize(20);

        //队列数，
        producer.setCheckRequestHoldMax(2000);

        producer.start();

        producer.setTransactionCheckListener(new TransactionCheckListener() {
            @Override
            public LocalTransactionState checkLocalTransactionState(MessageExt msg) {
                System.out.println("state------" + new String(msg.getBody()));
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });

        MyLocalTransactionExecuter executer = new MyLocalTransactionExecuter();
        for (int i = 1; i <= 2; i++) {
            Message message = new Message("topicTransaction", "Transcation" + i,
                    "key", ("Hello RocketMq" + i).getBytes());
            // message:发送的消息，executor: arg:
            TransactionSendResult tq = producer.sendMessageInTransaction(message, executer, "tq");
            System.out.println(tq);
        }
        TimeUnit.MICROSECONDS.sleep(1000);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                producer.shutdown();
            }
        }));
        System.exit(0);
    }
}

/**
 * @date
 * @see com.alibaba.rocketmq.client.producer.LocalTransactionExecuter
 */
class MyLocalTransactionExecuter implements LocalTransactionExecuter {
    @Override
    public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {
        // 在这里执行本地事务，是客户端的回调
        System.out.println("msg =" + new String(msg.getBody()));
        System.out.println("arg = " +arg);
        if (msg.getTags().equals("Transcation1")) {
            // 假设本地事务执行失败
            System.out.println("本地事务执行失败");
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
