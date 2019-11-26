package com.super404.springboot.service.impl;

import com.super404.springboot.domain.User;
import com.super404.springboot.mapper.UserMapper;
import com.super404.springboot.mapper.UserXmlMapper;
import com.super404.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserXmlMapper userXmlMapper;

    @Override
    public int add(User user) {
        userMapper.insert(user);
        int id = user.getId();
        return id;
    }

    @Override
    public int addByXml(User user) {
        userXmlMapper.insertByXml(user);
        int id = user.getId();
        return id;
    }
}
