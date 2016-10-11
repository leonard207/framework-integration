package com.leonard.kafka.controller;

import com.leonard.kafka.controller.dto.UserDto;
import com.leonard.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ning.li on 2016/10/11.
 */
@RestController
public class KafkaController {

    @Autowired(required = false)
    private KafkaService kafkaService;


    @Value("#{properties['kafka.topic']}")
    private String topic;

    @RequestMapping("/send")
    public void sendMessage(UserDto dto){
        System.out.println(topic);
        System.out.println(dto);
        kafkaService.sendUserInfo(topic,dto);
    }
}
