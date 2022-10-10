package com.example.solution.entity;

import lombok.Data;

/**
 * @author: William.Peng
 * @date: 2022/10/10 13:17
 * @description:
 */
@Data
public class User {
    private Integer userId;

    private String userName;

    private String userPassword;
    private String salt;
    private String email;
    private String phone;
    public User(String username ,String userpassword){
        this.userName = username;
        this.userPassword = userpassword;
    }
}
