package com.leonard.kafka.service;

/**
 * Created by Leonard on 2016/10/11.
 */
public interface KafkaService {

    /**
     * 发消息
     * @param topic 主题
     * @param obj 发送内容
     */
    public void sendUserInfo(String topic, Object obj);
}
