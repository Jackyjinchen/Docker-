package com.jacky.hellodocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping
    public String hello(){
        Long views = redisTemplate.opsForValue().increment("views");
        return "Hello Springboot+Docker,views = "+views;
    }
}
