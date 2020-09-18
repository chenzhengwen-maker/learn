package com.example.springbootdemo;

import com.example.springbootdemo.utils.JedisPoolUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.UUID;

@SpringBootTest
public class RedisSetnxDemo {
    @Value("${spring.redis.host:10.8.14.104}")
    private String host;
    @Value("${spring.redis.port:8001}")
    private int port;
    @Value("${spring.redis.password:gnsaredisPassWd}")
    private String passowrd;
    @Autowired(required = true)
    RedisTemplate redisTemplate;
    @Test
    public void setnxDemo(){
        //Jedis jedis = new Jedis(host,port);
        //jedis.auth(passowrd);
        //2.向redis发起setnx命令写入lison=7788，其中NX表示使用“nx” 模式，“PX”表示失效时间的单位是毫秒
        JedisPool jedisPool = JedisPoolUtils.getJedisPool();
        Jedis jedis = jedisPool.getResource();
        String ret = jedis.set("lison1111", "8889","NX","PX",10000000);
        System.out.println(ret);
        jedis.close();
    }
}
