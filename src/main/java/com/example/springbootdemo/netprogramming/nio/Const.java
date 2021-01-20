package com.example.springbootdemo.netprogramming.nio;

import java.time.LocalDate;

public class Const {
    public static int DEFAULT_PORT =12345;
    public static String DEFAULT_SERVER_IP = "127.0.0.1";
    public static String reponse(String msg){
         return "Hello "+msg+" ,Now is"+ LocalDate.now().toString();
    }

}
