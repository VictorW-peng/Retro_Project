package com.example.solution.service;

import com.example.solution.entity.User;

import java.util.List;

/**
 * 用户服务。
 *
 * @author William.Peng
 */
public interface UserService {

    /**
     * 展示所有用户信息。
     */
    List<User> showAllUser();

    /**
     * 通过用户名查找用户，不存在时返回 null。
     */
    User findUserByName(String userName);

    /**
     * 批量新增用户。
     *
     * @return 是否全部写入成功
     */
    boolean insertUserBatch(List<User> users);

    /**
     * 登录校验。
     *
     * @return 校验通过返回 true
     * @throws com.example.common.exception.BusinessException 用户名或密码错误时抛出
     */
    boolean login(String userName, String passWord);
}
