package com.leonard.rabbitmq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lining on 2015/10/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq.xml")
public class RabbitMQTest {

    @Autowired
    RabbitTemplate amqpTemplate;

    @Test
    public void test() throws InterruptedException {

        String message = "Hello World Leonard ";
       // amqpTemplate.convertAndSend("myExchange","","");
        //for (int i = 1; i < 10; i++) {
          //  amqpTemplate.convertAndSend("myExchange", "foo.bar","receive[" +  i + "]msg=" + message);
           // Thread.sleep(3600);
       // }

    }
}
