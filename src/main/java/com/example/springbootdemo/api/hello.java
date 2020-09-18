package com.example.springbootdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class hello {
    @Autowired(required = true)
    RedisTemplate redisTemplate;
    @RequestMapping("hello")
    public String hello() {
        redisTemplate.opsForValue().set("aaaaaaa","ttt");
        return "Hello this is my first springboot demo";
    }

}
