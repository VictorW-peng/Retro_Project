package com.example.retro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: William.Peng
 * @date: 2022/9/23 8:48
 * @description:
 */
@RestController
public class test {
    @RequestMapping("/test")
    public String fine(){
        return "this is test programmer";
    }
}
