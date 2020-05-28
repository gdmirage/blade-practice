package com.blade.practice.redis;

import com.blade.practice.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/18 22:25
 */
public class RedisClient {

    private static JedisPool jedisPool;

    @Value("redis.host")
    private static String host;

    @Value("redis.port")
    private static int port;

    @Value("redis.maxTotal")
    private static int maxTotal;

    @Value("redis.maxIdle")
    private static int maxIdle;

    private static void init(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(5000);

        jedisPool = new JedisPool(config, host, port);
    }

    public static Jedis getJedis(){
        return getJedisPool().getResource();
    }

    private static JedisPool getJedisPool() {
        if(null == jedisPool) {
            init();
        }
        return jedisPool;
    }
}
