package com.example.springbootdemo.concurrentprogramming;

public class AccountNomal implements Account{
    private int balance;
    public AccountNomal(int balance){
        this.balance = balance;
    }
    @Override
    public Integer query() {
        return this.balance;
    }

    @Override
    public void acquire(Integer i) {
        synchronized (this) {
            this.balance -= i;
        }

    }
}
