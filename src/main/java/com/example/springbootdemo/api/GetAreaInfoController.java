package com.example.springbootdemo.api;

import com.example.springbootdemo.mapper.CommonQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/getArea")
public class GetAreaInfoController {
    @Autowired
    private CommonQuery mapper;

    @RequestMapping("querylist")
    public List<Map<String,Object>> queryList() {
        List<Map<String, Object>> list = new ArrayList<>();
        list = mapper.queryList();
        return list;
    }

}
