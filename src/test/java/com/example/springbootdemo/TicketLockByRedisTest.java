package com.example.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
public class TicketLockByRedisTest {
    private int count = 100;// 100张票

    @Resource(name="redisLock")
    private Lock lock;

    @Test
    public void ticketTest() throws InterruptedException {
        TicketRunnable tr = new TicketRunnable();
        // 四个线程对应四个窗口
        Thread t1 = new Thread(tr, "窗口A");
        Thread t2 = new Thread(tr, "窗口B");
        Thread t3 = new Thread(tr, "窗口C");
        Thread t4 = new Thread(tr, "窗口D");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread.currentThread().join();
    }

    public class TicketRunnable implements Runnable{

        @Override
        public void run() {
            while (count > 0) {
                lock.lock();
                try {
                    if (count > 0) {
                        System.out.println(Thread.currentThread().getName() + "出售" + (count--) + "票");
                    }
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }
            /*try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }*/

        }
    }
}
