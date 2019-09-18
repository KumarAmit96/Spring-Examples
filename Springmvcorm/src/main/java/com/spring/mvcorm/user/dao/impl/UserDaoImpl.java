package com.spring.mvcorm.user.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.spring.mvcorm.user.dao.UserDao;
import com.spring.mvcorm.user.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int create(User user) {
		Integer result= (Integer)hibernateTemplate.save(user);
		return result;
	}

	public List<User> findUser() {
		return hibernateTemplate.loadAll(User.class);
	}

}
