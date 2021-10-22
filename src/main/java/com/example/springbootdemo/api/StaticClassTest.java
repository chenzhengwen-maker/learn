package com.example.springbootdemo.api;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;

public class StaticClassTest {
    public StaticClassTest() {
        System.out.println("3333");
    }

    public static void main(String[] args) {
        StaticMethodTest.print();
        double a = 1.0;
        double b = 20.2;
        double c = 300.02;
        System.out.println(a+b+c);
        BigDecimal a1 = new BigDecimal(Double.toString(a));

        BigDecimal b1 = new BigDecimal(Double.toString(b));

        BigDecimal c1 = new BigDecimal(Double.toString(c));

        double result = (a1.add(b1).add(c1)).doubleValue();

        System.out.println(result);
        try {
            InetAddress[] inetadd = InetAddress.getAllByName("www.baidu.com");
            for (int i = 0; i < inetadd.length; i++) {
                System.out.println(inetadd[i]);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
