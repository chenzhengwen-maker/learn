package com.example.springbootdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
@Component
public class JedisPoolUtils {

    private static String host;
    private static int port;
    private static String passowrd;
    private static JedisPool jedisPool = null;

    public static JedisPool getJedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(30);
        jedisPoolConfig.setMaxWaitMillis(2000);
        if(jedisPool == null) {
            synchronized(JedisPoolUtils.class) {
                jedisPool = new JedisPool(jedisPoolConfig, host, port, 200000, passowrd);
            }
        }
        return jedisPool;
    }

    @Value("${spring.redis.host:10.8.14.104}")
    public void setHost(String host) {
        this.host = host;
    }
    @Value("${spring.redis.port:8001}")
    public void setPort(int port) {
        this.port = port;
    }
    @Value("${spring.redis.password:gnsaredisPassWd}")
    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }
}
