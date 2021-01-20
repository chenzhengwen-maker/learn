package com.example.springbootdemo.netprogramming.nio;

import java.io.IOException;
import java.util.Scanner;
import static com.example.springbootdemo.netprogramming.nio.Const.DEFAULT_SERVER_IP;

public class NioClient {
    private static NioClientHandler nioClientHandle;

    public static void start(){
        //nioClientHandle = new NioClientHandle(DEFAULT_SERVER_IP,DEFAULT_PORT);
        nioClientHandle = new NioClientHandler(DEFAULT_SERVER_IP,12345);
        new Thread(nioClientHandle,"Server").start();
    }
    //向服务器发送消息
    public static boolean sendMsg(String msg) throws Exception{
        nioClientHandle.sendMsg(msg);
        return true;
    }
    public static void main(String[] args) throws Exception {
        start();
        Scanner scanner = new Scanner(System.in);
        while(NioClient.sendMsg(scanner.next()));

    }

}
