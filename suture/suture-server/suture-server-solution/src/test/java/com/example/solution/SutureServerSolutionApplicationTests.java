package com.example.solution;

import com.example.solution.dao.UserMapper;
import com.example.solution.entity.User;
import com.example.solution.service.UserService;
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

	@Resource
	private UserService userService;
	@Test
	void contextLoads() throws SQLException {
		System.out.println(dataSource.getConnection());
	}
	@Test
	void test1() throws SQLException {
		List<User> users = userMapper.selectAllUser();
		users.forEach(user -> System.out.println(user));
	}
	@Test
	void test2() throws SQLException {
		User user = new User("a" ,"1");
		System.out.println(user);
		userMapper.insertUser(user);
		System.out.println(user);
	}
	@Test
	void test3() throws SQLException {
		User user =userMapper.selectUserByName("wp");
		System.out.println(user);

		System.out.println(userService.findUserByName("wp"));
	}
}
