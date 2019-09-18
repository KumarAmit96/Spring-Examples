package com.spring.mvcorm.user.services;

import java.util.List;

import com.spring.mvcorm.user.entity.User;

public interface UserService {
	
	int save (User  user);
	
	List<User> getUsers();

}
