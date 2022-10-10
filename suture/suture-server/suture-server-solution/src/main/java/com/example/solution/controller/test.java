package com.example.solution.controller;

import com.example.solution.dao.UserMapper;
import com.example.solution.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: William.Peng
 * @date: 2022/10/10 13:26
 * @description:
 */
@RestController
public class test {
    @Resource
    private UserMapper userMapper;
    @RequestMapping("/test")
    public String test1(){
        List<User> users = userMapper.selectAllUser();
        String usernam = users.toString();
        return usernam;
    }
}
