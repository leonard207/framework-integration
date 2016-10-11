package com.leonard.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

/**
 *  接收消息
 * Created by Leonard on 2016/10/11.
 */
public class KafkaConsumerService {

    static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    public void processMessage(Map<String, Map<Integer, String>> msgs) {
        logger.info("==================processMessage==================");
        for (Map.Entry<String, Map<Integer, String>> entry : msgs.entrySet()) {
            logger.info("============Topic:" + entry.getKey());
            LinkedHashMap<Integer, String> messages = (LinkedHashMap<Integer, String>) entry.getValue();
            Set<Integer> keys = messages.keySet();
            for (Integer i : keys)
                logger.info("======Partition:" + i);
            Collection<String> values = messages.values();
            for (Iterator<String> iterator = values.iterator(); iterator.hasNext(); ) {
                String message = "[" + iterator.next() + "]";
                logger.info("=====message:" + message);
            }
        }
    }
}
