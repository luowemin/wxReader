package com.hqyt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hqyt.dao.IUserDao;
import com.hqyt.model.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao{
	
	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.openSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean isExit(User user) {
		Session session = this.getSession();
		String hql = "from User where name=?";
		Query query = session.createQuery(hql);
		query.setString(0, user.getName());
		
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		System.out.println(list.get(0).getEnName());
		return false;
	}

}
