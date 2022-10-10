package com.example.solution.dao;

import com.example.solution.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author: William.Peng
 * @date: 2022/10/10 13:22
 * @description:
 */
public interface UserMapper {

    int insertUser();

    List<User> selectAllUser();
}
