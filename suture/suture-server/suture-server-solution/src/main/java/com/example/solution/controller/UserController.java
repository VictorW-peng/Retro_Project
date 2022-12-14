package com.example.solution.controller;

import com.example.solution.entity.User;
import com.example.solution.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: William.Peng
 * @date: 2022/10/13 10:26
 * @description:
 */
@RestController
@RequestMapping("user")
@Api(tags = "User接口")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/allUser")
    @ApiOperation(value = "查询所有用户信息")
    public List<User> showAllUser(){
        return userService.showAllUser();
    }

    /**
     * @ApiOperation 接口方法描述
     * @ApiImplicitParams  api中参数含义描述
     */
    @GetMapping("/UserByName")
    @ApiOperation(value = "通过用户名查询")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "用户名" ,name = "userName" ,paramType = "String")
    })
    public User findUserByName(@RequestParam("userName") String userName){
        return userService.findUserByName(userName);
    }

    @PostMapping("/Login")
    public boolean login (@RequestParam("userName") String userName , @RequestParam("passWord") String passWord){
        boolean isExist = false;
        String username = userName;
        String password = passWord;
        User user = userService.findUserByName(userName);
        if(user.getUserPassword().equals(password)){
            isExist = true;
        }
        return isExist;
    }
}
