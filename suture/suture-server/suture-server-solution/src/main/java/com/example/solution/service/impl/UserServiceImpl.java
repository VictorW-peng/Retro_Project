package com.example.solution.service.impl;

import com.example.common.api.ErrorCode;
import com.example.common.exception.BusinessException;
import com.example.solution.dao.UserMapper;
import com.example.solution.entity.User;
import com.example.solution.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 用户服务实现。
 *
 * @author William.Peng
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public List<User> showAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User findUserByName(String userName) {
        return userMapper.selectUserByName(userName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertUserBatch(List<User> users) {
        if (users == null || users.isEmpty()) {
            return false;
        }
        int affectedRows = userMapper.insertManyUser(users);
        return affectedRows == users.size();
    }

    @Override
    public boolean login(String userName, String passWord) {
        User user = userMapper.selectUserByName(userName);
        if (user == null || !Objects.equals(user.getUserPassword(), passWord)) {
            throw new BusinessException(ErrorCode.LOGIN_FAILED);
        }
        return true;
    }
}
