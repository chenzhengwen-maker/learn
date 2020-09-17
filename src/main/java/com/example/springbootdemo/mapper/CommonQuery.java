package com.example.springbootdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface CommonQuery {
    /**
     * 测试Mapper
     * @param
     * @return
     */
    List<Map<String, Object>> queryList( );
}
