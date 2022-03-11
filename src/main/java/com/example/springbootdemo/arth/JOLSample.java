package com.example.springbootdemo.arth;

import org.openjdk.jol.info.ClassLayout;

class A{
    int i;
    int j;
    B b = new B();
}
class B{
    int j;
    int a;
}
public class JOLSample {
    public static void main(String[] args) {
        ClassLayout layout = ClassLayout.parseInstance(new A());
        System.out.println(layout.toPrintable());
    }

}
