package com.example.springbootdemo.concurrentprogramming;

import java.util.ArrayList;
import java.util.List;

public class AccountTest {
    public static void main(String[] args) throws InterruptedException {
        test(new AccountNomal(100000));
    }
    public static void test(Account account) throws InterruptedException {
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            ts.add(new Thread(()->{
                account.acquire(20);
            }));
        }
        for (Thread t:ts) {
            t.start();
        }
        for (Thread t : ts) {
            t.join();
        }
        System.out.println(account.query());

    }
}
