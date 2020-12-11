package com.example.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicketSychTest {
    private int count = 100;// 100张票

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
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("i am t5");
            }
        });
        t5.start();
        Thread.currentThread().join();
    }

    public class TicketRunnable implements Runnable{

        @Override
        public void run() {
            while (count > 0) {
                synchronized (this) {
                    if (count > 0) {
                        System.out.println(Thread.currentThread().getName() + "出售" + (count--) + "票");
                    }
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
