package com.example.solution.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户实体。
 *
 * @author William.Peng
 */
@Data
@Schema(description = "用户实体")
public class User extends BaseEntity {

    @Schema(description = "用户编号")
    private Integer userId;

    @Schema(description = "用户名")
    @ExcelProperty("用户姓名")
    private String userName;

    /**
     * 只允许写入，不允许序列化输出，避免密码泄漏。
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ExcelProperty("用户密码")
    private String userPassword;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String salt;

    @ExcelProperty("用户邮箱")
    private String email;

    @ExcelProperty("用户手机号")
    private String phone;

    @ExcelProperty("用户性别")
    private Integer gender;

    public User(String username, String userpassword) {
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

    public User() {
    }
}
