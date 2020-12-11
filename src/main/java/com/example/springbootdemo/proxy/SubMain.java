package com.example.springbootdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class SubMain {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        InvocationHandler subjectProxy = new SubjectProxy(subject);
        Subject proxyInstance = (Subject)Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),subjectProxy);
        proxyInstance.hello("sss");
    }
}
