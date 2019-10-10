package com.mvc.javas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.javas.service.EmployeeManager;

@Component
@RequestMapping("/employee-module")
public class EmployeeController {

	@Autowired
	EmployeeManager empmng;

	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public String getEmployeeList(Model model) {
		model.addAttribute("employee", empmng.getEmployeeList());
		return "employeeDisplay";
	}

}
