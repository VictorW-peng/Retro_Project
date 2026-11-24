package com.example.solution.dao;

import com.example.solution.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 用户表数据访问接口。
 *
 * @author William.Peng
 */
public interface UserMapper {

    Integer insertUser(User user);

    List<User> selectAllUser();

    User selectUserByName(@Param("userName") String userName);

    Integer updatePasswordById(@Param("userId") Integer userId,
                               @Param("password") String password,
                               @Param("modifiedUser") String modifiedUser,
                               @Param("modifiedTime") Date modifiedTime);

    int insertManyUser(@Param("users") List<User> users);
}
