package com.web.app.spingmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.app.spingmvc.dto.User;

@Controller
public class UserController {
	
	
	@RequestMapping("registrationPage")
	public String showRegistrationView() {
		return "userReg";
	}
	
	@RequestMapping(value ="registerUser", method =RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user,ModelMap map)
	{
		map.addAttribute("user", user);
		return "regResult";
	}

	
	
	/*
	 * @RequestMapping("registrationPage") public ModelAndView
	 * showRegistrationView() { ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("userReg"); return modelAndView; }
	 * 
	 * @RequestMapping(value ="registerUser", method =RequestMethod.POST) public
	 * ModelAndView registerUser(@ModelAttribute("user") User user) {
	 * System.out.println(user); ModelAndView modelAndView = new ModelAndView();
	 * modelAndView.setViewName("regResult"); modelAndView.addObject("user", user);
	 * return modelAndView; }
	 */
}
