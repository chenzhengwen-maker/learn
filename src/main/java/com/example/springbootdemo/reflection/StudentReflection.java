package com.example.springbootdemo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentReflection {
    public static void main(String[] args) {
        Student stu = new Student();
        Class stuClass = stu.getClass();
        System.out.println(stuClass.getName());

        Class stuClass2 = Student.class;
        System.out.println(stuClass == stuClass2);

        try {
            Class stuClass3 = Class.forName("com.example.springbootdemo.reflection.Student");
            System.out.println(stuClass2==stuClass3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------所有共有构造方法-------------------------");
        Constructor[] constructor = stuClass2.getConstructors();
        for(Constructor c:constructor){
            System.out.println(c);
        }
        try {
            Constructor con = stuClass2.getConstructor();
            try {
                con.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------获取所有公有的字段-------------------------");
        Field[] fields = stuClass2.getFields();
        for(Field f:fields){
            System.out.println(f);
        }

        System.out.println("----------------------获取所有公有的方法-------------------------");
        Method[] methods = stuClass2.getMethods();
        for(Method m:methods){
            System.out.println(m);
        }
        try {
            Method m = stuClass2.getMethod("show1", String.class);
            try {
                Object obj = stuClass2.newInstance();
                try {
                    m.invoke(obj,"czw");
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
