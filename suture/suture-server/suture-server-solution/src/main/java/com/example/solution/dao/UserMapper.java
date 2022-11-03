package com.example.solution.dao;

import com.example.solution.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: William.Peng
 * @date: 2022/10/10 13:22
 * @description:
 */
public interface UserMapper {

    Integer insertUser(User user);

    List<User> selectAllUser();

    User selectUserByName(String username);

    Integer updatePasswordById(Integer userid , String password , String modifiedUser, Date modifiedTime);

    void insertManyUser(@Param("users") List<User> users);

}
