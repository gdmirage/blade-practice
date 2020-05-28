package com.blade.practice.redis.lock;

import com.blade.practice.redis.RedisClient;
import redis.clients.jedis.Jedis;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/19 13:22
 */
public class RedisDistributedLock {

    public void getLock() {
        Jedis jedis = RedisClient.getJedis();

        long result = jedis.setnx("key","value");

        if(1 == result) {
            jedis.expire("key", 1);
        }
    }
}
