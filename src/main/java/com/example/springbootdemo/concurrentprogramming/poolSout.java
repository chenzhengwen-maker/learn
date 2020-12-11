package com.example.springbootdemo.concurrentprogramming;

import java.util.ArrayList;
import java.util.List;

public class poolSout implements Runnable{
    private String s;
    public poolSout(String s){
      this.s = s;
    }
    @Override
    public void run() {
        System.out.println(s);
    }
}
