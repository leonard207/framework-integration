package com.leonard.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *  redis client
 */
public class RedisClient {
    private static final Logger log = LoggerFactory.getLogger(RedisClient.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加到缓存
     * @param key
     *         若缓存pojo实体，使用class名称+实体主键为key
     * @param value
     * @param times
     *             过期时间，毫秒数
     */
    public void save(final String key, final String value,final Long times) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(
                        redisTemplate.getStringSerializer().serialize(key),
                        redisTemplate.getStringSerializer().serialize(value));
                if (times != null && times > 0){
                    connection.expire(redisTemplate.getStringSerializer().serialize(key),times/1000);
                }

                return null;
            }
        });
    }


    public Object read(final String key) {
        return redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] keys = redisTemplate.getStringSerializer().serialize(
                        key);
                if (connection.exists(keys)) {
                    byte[] value = connection.get(keys);
                    return redisTemplate.getStringSerializer()
                            .deserialize(value);
                }
                return null;
            }
        });
    }


    public void delete(final String key) {
        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection) {
                connection.del(redisTemplate.getStringSerializer().serialize(
                        key));
                return null;
            }
        });
    }

}
