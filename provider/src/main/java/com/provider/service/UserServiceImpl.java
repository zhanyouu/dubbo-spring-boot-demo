package com.provider.service;

import com.api.service.UserService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0",interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {
    @Override
    public String getUser() {
        return "hello";
    }
}
