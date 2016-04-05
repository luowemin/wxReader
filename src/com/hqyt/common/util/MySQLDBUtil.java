package com.hqyt.common.util;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("commonDao")
public class MySQLDBUtil {

	@Resource
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.openSession();
	}
	
	public Query getQuery(String hql,Object...params){
		Session session = getSession();
		Query query = session.createQuery(hql);
		if(params !=null){
		
			for (int i=0;i< params.length;i++) {
				Object obj = params[i];
				if(obj instanceof String){
					query.setString(i, (String)obj);
				}else if(obj instanceof Integer){
					query.setInteger(i, (Integer)obj);
				}
			}
		}
		return query;
	}
	
	public void save(){
		
	}
	
	public void closeSession(){
		sessionFactory.close();
	}
}
