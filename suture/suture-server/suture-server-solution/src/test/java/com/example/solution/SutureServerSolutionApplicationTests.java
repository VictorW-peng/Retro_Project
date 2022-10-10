package com.example.solution;

import com.example.solution.dao.UserMapper;
import com.example.solution.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SutureServerSolutionApplicationTests {
	@Autowired
	private DataSource dataSource;

	@Resource
	private UserMapper userMapper;
	@Test
	void contextLoads() throws SQLException {
		System.out.println(dataSource.getConnection());
	}
	@Test
	void test1() throws SQLException {
		List<User> users = userMapper.selectAllUser();
		users.forEach(user -> System.out.println(user));
	}
}
