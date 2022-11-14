package com.example.solution.service;

import com.example.solution.dao.UserMapper;
import com.example.solution.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: William.Peng
 * @date: 2022/10/13 10:02
 * @description:
 */
public interface UserService {

    /**
     * 展示所有用户信息
     * @return
     */
    public List<User> showAllUser();

    /**
     * 通过userName找用户
     * @param userName
     * @return
     */
    public User findUserByName(String userName);

    public boolean insertUserBatch(List<User> users);
}
