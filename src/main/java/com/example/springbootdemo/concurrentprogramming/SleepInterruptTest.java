package com.example.springbootdemo.concurrentprogramming;

public class SleepInterruptTest {
    public static void main(String[] args) {
        SleepThread t1 = new SleepThread();

        t1.start();
        t1.interrupt();//主动打断线程，使SleepThread线程抛出异常


    }
}
