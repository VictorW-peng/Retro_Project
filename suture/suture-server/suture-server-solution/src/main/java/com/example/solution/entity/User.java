package com.example.solution.entity;

import com.alibaba.excel.annotation.ExcelProperty;
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
    @ExcelProperty("用户姓名")
    private String userName;

    @ExcelProperty("用户密码")
    private String userPassword;

    private String salt;

    @ExcelProperty("用户邮箱")
    private String email;

    @ExcelProperty("用户手机号")
    private String phone;

    @ExcelProperty("用户性别")
    private Integer gender;

    public User(String username ,String userpassword){
        this.userName = username;
        this.userPassword = userpassword;
    }

    public User(String userName, String userPassword, String salt, String email, String phone, Integer gender) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.salt = salt;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }

    public User(){
    }
}
