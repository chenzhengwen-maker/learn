package com.example.springbootdemo.netprogramming.nio;

import static com.example.springbootdemo.netprogramming.nio.Const.DEFAULT_PORT;

public class NioServer {
    private static NioServerHandler nioServerHandler;

    public static void main(String[] args) {
        nioServerHandler = new NioServerHandler(DEFAULT_PORT);
        new Thread(nioServerHandler,"nioServer").start();
    }
}
