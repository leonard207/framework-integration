package com.leonard.redis.test;

import com.leonard.redis.RedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by leonard on 2015/11/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class RedisTest {

    @Autowired
    private RedisClient redisClient;

    @Test
    public void testRedis() {
        long time = 10000000;
        String key = "leonard";
        String value = "test";
        redisClient.save(key,value,time);

        String result = (String)redisClient.read(key);
        System.out.println(result);

       // redisClient.delete(key);
    }
}
