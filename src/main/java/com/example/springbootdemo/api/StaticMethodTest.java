package com.example.springbootdemo.api;

public class StaticMethodTest {
    public static void print(){
        System.out.println("111");
    }

    public static StaticClassTest staticClassTest = new StaticClassTest();

    static {
        System.out.println("2222");
    }


    public static void main(String[] args) {
        //StaticClassTest staticClassTest = new StaticClassTest();
    }
}
