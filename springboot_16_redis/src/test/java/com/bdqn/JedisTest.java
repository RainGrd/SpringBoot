package com.bdqn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

/**
 * Copyright (C), 2017-2022, RainGrd
 * Author: lenovo
 * Date: 2022/10/8 12:57
 * FileName: JedisTest
 * Description:
 */
@SpringBootTest
public class JedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Jedis jedis;


    @Test
    void testJedis() {
        

    }
}
