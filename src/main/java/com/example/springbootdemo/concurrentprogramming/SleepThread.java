package com.example.springbootdemo.concurrentprogramming;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepThread extends Thread {
    @Override
    public void run() {
        while (true) {

            try {

                SimpleDateFormat sim = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");

                System.out.println(sim.format(new Date()));

                sleep(1000);

            } catch (Exception e) {

                System.out.println("线程中断");

                return;

            }
        }
    }
}
