package com.example.springbootdemo.api;

import java.util.*;

public class CollectionDelete {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("1","test1");
        map.put("2","test2");
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if("1".equals(entry.getKey().toString())){
                iterator.remove();
            }
        }
        map.forEach((k,v)->{
            System.out.println(k.toString()+"|"+v.toString());
        });
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        for (Iterator iterator1 = list.iterator(); iterator1.hasNext(); ) {
            Integer i =  (Integer)iterator1.next();
            if(i.equals(2)){
                iterator1.remove();
            }
        }
        list.forEach((s)->{
            System.out.println(s);
        });
    }
}
