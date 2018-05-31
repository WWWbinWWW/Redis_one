package com.redis.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisAutoTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void save(){

        stringRedisTemplate.opsForValue().set("love","peace");
        assertEquals("peace",stringRedisTemplate.opsForValue().get("love"));
    }

}