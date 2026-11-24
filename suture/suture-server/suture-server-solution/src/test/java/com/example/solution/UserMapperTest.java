package com.example.solution;

import com.example.solution.dao.UserMapper;
import com.example.solution.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * UserMapper 集成测试，使用 H2 内存库，不依赖本机 MySQL。
 */
@SpringBootTest
@ActiveProfiles("test")
@Transactional
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void shouldSelectAllUsers() {
        List<User> users = userMapper.selectAllUser();
        assertEquals(2, users.size());
        assertEquals("wp", users.get(0).getUserName());
    }

    @Test
    void shouldSelectUserByName() {
        User user = userMapper.selectUserByName("wp");
        assertNotNull(user);
        assertEquals("wp@example.com", user.getEmail());
    }

    @Test
    void shouldReturnNullWhenUserNotFound() {
        assertNull(userMapper.selectUserByName("not-exist"));
    }

    @Test
    void shouldInsertUserAndGenerateId() {
        User user = new User("bob", "pwd123");
        user.setEmail("bob@example.com");
        user.setCreateUser("test");
        user.setCreateTime(new Date());

        assertEquals(1, userMapper.insertUser(user));
        assertNotNull(user.getUserId());

        User saved = userMapper.selectUserByName("bob");
        assertNotNull(saved);
        assertEquals("bob@example.com", saved.getEmail());
    }

    @Test
    void shouldUpdatePasswordAndAuditFields() {
        User user = userMapper.selectUserByName("wp");
        Date now = new Date();

        assertEquals(1, userMapper.updatePasswordById(user.getUserId(), "new-password", "tester", now));

        User updated = userMapper.selectUserByName("wp");
        assertEquals("new-password", updated.getUserPassword());
        assertEquals("tester", updated.getModifiedUser());
    }

    @Test
    void shouldInsertUsersInBatch() {
        List<User> users = Arrays.asList(
                new User("batch-1", "p1"),
                new User("batch-2", "p2"));

        assertEquals(2, userMapper.insertManyUser(users));
        assertEquals(4, userMapper.selectAllUser().size());
    }
}
