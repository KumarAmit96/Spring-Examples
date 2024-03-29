package com.spring.mvcorm.user.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvcorm.user.dao.UserDao;
import com.spring.mvcorm.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Transactional
	public int save(User user) {
		// Business Logic
		return dao.create(user);
	}

	public List<User> getUsers() {
		List<User> users = dao.findUser();
		Collections.sort(users);
		return users;
	}

}
