package com.redis.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RedisServiceString {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 写入缓存
     * @param key
     * @param value
     */
    public void set(String key, String value){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(key, value);
    }

    /**
     * 获得数据
     * @param key
     * @return
     */
    public String get(String key){
        String result;
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 判断是否存在键值
     * @param key
     * @return
     */
    public boolean exists(String key){
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 删除键值
     * @param key
     */
    public void remove(String key){
        if(exists(key))
            stringRedisTemplate.delete(key);
    }

    /**
     * 添加哈希键
     * @param key
     * @param hashKey
     * @param value
     */
    public void hsSet(String key, String hashKey, String value){
        HashOperations<String, String, String> operations = stringRedisTemplate.opsForHash();
        operations.put(key, hashKey, value);
    }

    /**
     * 获取哈希值
     * @param key
     * @param hashKey
     * @return
     */
    public String hsGet(String key, String hashKey){
        HashOperations<String, String, String> operations = stringRedisTemplate.opsForHash();
        return operations.get(key, hashKey);
    }

    /**
     * 列表添加
     * @param key
     * @param value
     */
    public void lPush(String key, String value){
        ListOperations<String, String> list = stringRedisTemplate.opsForList();
        list.rightPush(key, value);
    }

    /**
     * 列表获取
     * @param key
     * @param l
     * @param l1
     * @return
     */
    public List<String> lRange(String key, long l, long l1){
        ListOperations<String, String> list = stringRedisTemplate.opsForList();
        return list.range(key, l, l1);
    }

    /**
     * 集合添加
     * @param key
     * @param value
     */
    public void sadd(String key, String value){
        SetOperations<String, String> set = stringRedisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<String> sget(String key){
        SetOperations<String, String> set = stringRedisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param score
     */
    public void zadd(String key, String value, double score){
        ZSetOperations<String, String> zset = stringRedisTemplate.opsForZSet();
        zset.add(key, value, score);
    }

    /**
     * 有序集合获取
     * @param key
     * @param score1
     * @param score2
     * @return
     */
    public Set<String> rangebyscore(String key, double score1, double score2){
        ZSetOperations<String, String> zset = stringRedisTemplate.opsForZSet();
        return zset.rangeByScore(key, score1, score2);
    }
}
