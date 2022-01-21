package com.provider.controller;


import com.api.Bean.Good;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/test")
    public void getStock(){
        Good good = new Good();
        good.setId(123);
        redisTemplate.opsForValue().set("good",good);
    }
}
