package com.example.springbootdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/hello")
public class hello {
    @Autowired(required = true)
    RedisTemplate redisTemplate;
    @Autowired
    ApplicationContext applicationContext;
    @RequestMapping("hello")
    public String hello() throws IOException {
        /*Resource resources = applicationContext.getResource("classpath:application.properties");
        resources.getFile();
        redisTemplate.opsForValue().set("aaaaaaa","ttt");*/
        return "Hello this is my first springboot demo";
    }

}
