/**
 * @author William.Patrick
 * @data 2022/10/10 22:55
 */
package com.example.solution;

import com.example.solution.dao.UserMapper;
import com.example.solution.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    void test1(){
        User wp = userMapper.selectUserByName("wp");
        System.out.println(wp);
    }
}
