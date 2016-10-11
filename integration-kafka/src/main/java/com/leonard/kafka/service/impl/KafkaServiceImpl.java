package com.leonard.kafka.service.impl;


import com.leonard.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by Leonard on 2016/10/11.
 */
@Service("kafkaService")
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    @Qualifier("kafkaTopicTest")
    MessageChannel channel;

    public void sendUserInfo(String topic, Object obj) {
        channel.send(MessageBuilder.withPayload(obj)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build());
    }

}
