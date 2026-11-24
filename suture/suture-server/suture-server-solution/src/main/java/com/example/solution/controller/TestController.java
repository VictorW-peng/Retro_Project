package com.example.solution.controller;

import com.example.common.api.Result;
import com.example.solution.entity.User;
import com.example.solution.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 示例接口，用于演示统一响应结构。
 *
 * @author William.Peng
 */
@RestController
@Tag(name = "示例接口")
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    @GetMapping("/test")
    @Operation(summary = "查询全部用户（示例）")
    public Result<List<User>> test() {
        return Result.ok(userService.showAllUser());
    }
}
