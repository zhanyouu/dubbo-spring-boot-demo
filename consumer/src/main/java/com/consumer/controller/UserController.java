package com.consumer.controller;

import com.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Reference(version = "1.0.0")
    private UserService userService;
    @RequestMapping("/getUser")
    public String getUser(){
        return userService.getUser();
    }
    @RequestMapping("/getName")
    public String getName(){
        return userService.getName();
    }
}
