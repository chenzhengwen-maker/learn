package com.example.springbootdemo.concurrentprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TheadPoolTest {
    private static ExecutorService executor = Executors.newFixedThreadPool(20);
    private ExecutorService executorService2 = Executors.newCachedThreadPool();
    private ExecutorService executorService3 = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("s");
        list.add("b");
        list.add("c");
        list.add("d");
        for(String s:list) {
            executor.execute(new poolSout(s));
        }
        executor.shutdown();
    }

}
