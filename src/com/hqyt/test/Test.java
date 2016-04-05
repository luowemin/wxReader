package com.hqyt.test;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hqyt.common.util.MySQLDBUtil;
import com.hqyt.dao.IUserDao;
import com.hqyt.model.User;
import com.hqyt.service.IUserService;

@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {

	@Resource
	private IUserDao userDao;
	
	@Resource
	private MySQLDBUtil commonDao;
	
	@Resource
	private IUserService userService;
	
	@org.junit.Test
	public void testIsExit(){
		User user = new User();
		user.setName("安庆");
		userService.isExit(user);
	}
	
	@org.junit.Test
	public void testUtil(){
		Query q = commonDao.getQuery("from User where name=? and enName=?","安庆","anqing");
		System.out.println(q.list());
	}
	
	@org.junit.Test
	public void testInstance(){
		System.err.println("error");
	}
}
