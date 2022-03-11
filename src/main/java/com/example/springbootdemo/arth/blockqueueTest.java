package com.example.springbootdemo.arth;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class blockqueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
        for (int i = 0; i < 10; i++) {
            blockingQueue.put(i);
        }
        int j=0;
        while(true){
            System.out.println(blockingQueue.take());
            j++;
            System.out.println(j);
        }
    }
}
