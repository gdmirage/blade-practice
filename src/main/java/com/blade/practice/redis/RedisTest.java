package com.blade.practice.redis;

import com.blade.practice.scan.ScanAnnotation;
import com.blade.util.Sl4jLoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/18 22:21
 */
public class RedisTest {

    private static Logger LOGGER = LoggerFactory.getLogger(RedisTest.class);

    public static void main(String[] args) throws Exception {
        ScanAnnotation.scan();

        Jedis jedis = RedisClient.getJedis();
        String key = "lock";
        Sl4jLoggerUtils.info(LOGGER, jedis.setnx(key, "blade").toString());
        Sl4jLoggerUtils.info(LOGGER, jedis.setnx(key, "blade").toString());
    }
}
