package com.anxing.anxingservice.service;

import com.anxing.anxingservice.mapper.UserMapper;
import com.anxing.anxingservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    public int insert(String openid) {
        return userMapper.insert(openid);
    }

    public List<User> getByOpenid(String openid) {
        return userMapper.getByOpenid(openid);
    }

}
