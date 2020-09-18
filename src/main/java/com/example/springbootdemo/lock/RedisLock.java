package com.example.springbootdemo.lock;

import com.example.springbootdemo.utils.FileUtils;
import com.example.springbootdemo.utils.JedisPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@Service
public class RedisLock implements Lock {

    private static final String LOCK = "lock";

    private static final ThreadLocal<String> threadlocal = new ThreadLocal<>();

    @Override
    public void lock() {
        while(true){
            if(tryLock()){
                return;
            }else{
                try{
                    Thread.sleep(10);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                }
            }
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        String uuid = UUID.randomUUID().toString();
        //Jedis jedis = (Jedis)jedisConnectionFactory.getConnection().getNativeConnection();
        JedisPool jedisPool = JedisPoolUtils.getJedisPool();
        Jedis jedis = jedisPool.getResource();
        String ret = jedis.set(LOCK, uuid, "NX", "PX", 3000);
        jedis.close();
        if(ret != null && "OK".equals(ret)){
            threadlocal.set(uuid);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        String uuid = UUID.randomUUID().toString();
        //Jedis jedis = (Jedis)jedisConnectionFactory.getConnection().getNativeConnection();
        JedisPool jedisPool = JedisPoolUtils.getJedisPool();
        Jedis jedis = jedisPool.getResource();
        String ret = jedis.set(LOCK, uuid, "NX", "PX", 3000);
        jedis.close();
        if(ret != null && "OK".equals(ret)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void unlock() {
        String script = FileUtils.readFileByLines("E://NewWorkSpaces//springbootdemo//src//main//resources//unlock.lua");
        //Jedis jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
        JedisPool jedisPool = JedisPoolUtils.getJedisPool();
        Jedis jedis = jedisPool.getResource();
        jedis.eval(script, Arrays.asList(LOCK),Arrays.asList(threadlocal.get()));
        jedis.close();

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
