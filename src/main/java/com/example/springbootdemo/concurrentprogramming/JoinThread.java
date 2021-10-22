package com.example.springbootdemo.concurrentprogramming;

import java.util.Iterator;

public class JoinThread {
    public static void main(String[] args) {
        A a = new A();
        a.start();
        try {
            a.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        B b = new B();
        b.start();
        System.out.println("main");

    }

}
class A extends Thread{
    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a");
    }
}
class B extends Thread{
    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b");
    }
}

