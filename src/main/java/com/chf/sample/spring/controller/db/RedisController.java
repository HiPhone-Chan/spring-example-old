package com.chf.sample.spring.controller.db;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chf.sample.spring.nosql.redis.MyRedis;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    public MyRedis myRedis;

    @RequestMapping(method = GET)
    public String get(@RequestParam String key,
            @RequestParam(required = false) String value) {

        if (StringUtils.isEmpty(value)) {
            value = myRedis.get(key);
            return value;
        }

        myRedis.put(key, value);
        return "put success";
    }

}
