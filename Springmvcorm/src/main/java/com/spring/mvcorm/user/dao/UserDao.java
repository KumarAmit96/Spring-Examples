package com.spring.mvcorm.user.dao;

import java.util.List;

import com.spring.mvcorm.user.entity.User;

public interface UserDao {
	
	int create (User user);
	
	List<User> findUser();

}
