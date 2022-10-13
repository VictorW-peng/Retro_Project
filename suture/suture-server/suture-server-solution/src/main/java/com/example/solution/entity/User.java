package com.example.solution.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: William.Peng
 * @date: 2022/10/10 13:17
 * @description:
 */
@Data
@ApiModel(value = "用户实体类")
public class User extends BaseEntity{
    @ApiModelProperty(value = "用户编号")
    private Integer userId;
    @ApiModelProperty(value = "用户名")
    private String userName;

    private String userPassword;

    private String salt;

    private String email;

    private String phone;

    private Integer gender;

    private Integer isDelete;
    public User(String username ,String userpassword){
        this.userName = username;
        this.userPassword = userpassword;
    }
    public User(){
    }
}
