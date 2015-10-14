package com.leonard.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.PullResult;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class PullConsumer {

    private static final Map<MessageQueue, Long> offseTable = new HashMap<MessageQueue, Long>();


    public static void main(String[] args) throws MQClientException {
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("DEFAULT_MSG_CONSUMER");
        consumer.setNamesrvAddr("messagebox.rocketmq.master.yao.com:9876");
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.start();

            Set<MessageQueue> mqs = consumer.fetchSubscribeMessageQueues("MSG_BOX");
            for (MessageQueue mq : mqs) {
                System.out.println();
                System.out.println("Consume from the queue: " + mq);

                SINGLE_MQ:
                while (true) {
                    try {
                        PullResult pullResult =
                                consumer.pull(mq, null, getMessageQueueOffset(mq), 32);
                        System.out.println(pullResult);
                        putMessageQueueOffset(mq, pullResult.getNextBeginOffset());
                        switch (pullResult.getPullStatus()) {
                            case FOUND:
                                // TODO
                                break;
                            case NO_MATCHED_MSG:
                                break;
                            case NO_NEW_MSG:
                                break SINGLE_MQ;
                            case OFFSET_ILLEGAL:
                                break;
                            default:
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            consumer.shutdown();

        }




    private static void putMessageQueueOffset(MessageQueue mq, long offset) {
        offseTable.put(mq, offset);
    }


    private static long getMessageQueueOffset(MessageQueue mq) {
        Long offset = offseTable.get(mq);
        if (offset != null)
            return offset;

        return 0;
    }

}
