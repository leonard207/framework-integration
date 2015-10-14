package com.leonard.redis.test;

import com.leonard.redis.TestRedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lining on 2015/9/23.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class RedisTest extends AbstractJUnit4SpringContextTests {


    public void setTestRedis(TestRedis testRedis) {
        this.testRedis = testRedis;
    }

    private  TestRedis testRedis;

    @Test
    public void testRedis () {
        testRedis.save("ss","ss");
    }

}
