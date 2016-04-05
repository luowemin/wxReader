package com.hqyt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hqyt.dao.IUserDao;
import com.hqyt.model.User;
import com.hqyt.service.IUserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService{

	@Resource
	private IUserDao userDao;
	
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public boolean isExit(User user) {
		// TODO Auto-generated method stub
		return userDao.isExit(user);
	}

}
