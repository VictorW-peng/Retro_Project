package com.example.solution.service.impl;

import com.example.solution.dao.UserMapper;
import com.example.solution.entity.User;
import com.example.solution.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: William.Peng
 * @date: 2022/10/13 10:05
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> showAllUser(){
        return userMapper.selectAllUser();
    }

    @Override
    public User findUserByName(String userName){
        return userMapper.selectUserByName(userName);
    }
}
