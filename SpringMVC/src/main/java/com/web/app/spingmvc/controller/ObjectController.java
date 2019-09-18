package com.web.app.spingmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.app.spingmvc.dto.Employee;

@Controller
public class ObjectController {
	
	@RequestMapping("/readObject")
	public ModelAndView sendobject() 
	{	
		ModelAndView modelandview= new ModelAndView();
		modelandview.setViewName("displayObject");
		Employee employee=new Employee();
		employee.setId(123);
		employee.setName("Amit Kumar Singh");
		employee.setSalary(10000);
		modelandview.addObject("employee", employee);
		return modelandview;	
	}
	
}
