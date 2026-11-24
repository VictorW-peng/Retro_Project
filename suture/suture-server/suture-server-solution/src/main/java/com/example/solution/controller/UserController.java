package com.example.solution.controller;

import com.example.common.api.ErrorCode;
import com.example.common.api.Result;
import com.example.common.exception.BusinessException;
import com.example.solution.entity.User;
import com.example.solution.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 用户相关接口。
 *
 * @author William.Peng
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户接口")
@Validated
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/allUser")
    @Operation(summary = "查询所有用户信息")
    public Result<List<User>> showAllUser() {
        return Result.ok(userService.showAllUser());
    }

    @GetMapping("/UserByName")
    @Operation(summary = "通过用户名查询")
    public Result<User> findUserByName(
            @Parameter(description = "用户名", required = true)
            @RequestParam("userName") @NotBlank(message = "用户名不能为空") String userName) {
        User user = userService.findUserByName(userName);
        if (user == null) {
            throw new BusinessException(ErrorCode.DATA_NOT_FOUND, "用户不存在: " + userName);
        }
        return Result.ok(user);
    }

    @PostMapping("/Login")
    @Operation(summary = "用户登录校验")
    public Result<Boolean> login(
            @RequestParam("userName") @NotBlank(message = "用户名不能为空") String userName,
            @RequestParam("passWord") @NotBlank(message = "密码不能为空") String passWord) {
        return Result.ok(userService.login(userName, passWord));
    }
}
