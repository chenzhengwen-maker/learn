package com.example.springbootdemo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class hello {
    @RequestMapping("hello")
    public String hello() {
        return "Hello this is my first springboot demo";
    }

}
