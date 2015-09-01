package com.chf.sample.spring.nosql.redis;

import java.util.Arrays;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyRedis {

    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> template;

    // inject the template as ListOperations
    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    public void put(String key, String value) {
        template.opsForValue().set(key, value);
    }

    public String get(String key) {
        return template.opsForValue().get(key);
    }

    public Set<String> getKeys(String pattern) {
        return template.keys(pattern);
    }

    public void delete(String... keys) {

        if (keys != null) {
            if (keys.length == 1) {
                template.delete(keys[0]);
            } else {
                template.delete(Arrays.asList(keys));
            }
        }
    }
}
