package com.spring.mvcorm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvcorm.user.entity.User;
import com.spring.mvcorm.user.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("registrationPage")
	public String showRegistrationView() {
		return "userReg";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") com.spring.mvcorm.user.entity.User user, ModelMap map) {
		int result = userService.save(user);
		map.addAttribute("result", "User created with ID " + result);
		return "userReg";
	}

	@RequestMapping("getUsers")
	public String getUsers(ModelMap map) {
		List<User> users = userService.getUsers();
		map.addAttribute("users", users);
		return "displayUsers";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
