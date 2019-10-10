package com.form.validity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.form.validity.model.Employee;
import com.forms.validity.service.EmployeeManager;

@Component
@RequestMapping("/employee-module/addNew")
@SessionAttributes("employee")
public class EmployeeController {

	@Autowired
	EmployeeManager empmng;

	@RequestMapping(method=RequestMethod.GET)
	public String setForms(Model model)
	{
		Employee emp=new Employee();
		model.addAttribute("employee", emp);
		return "addEmployee";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("employee") Employee emp, BindingResult result,
			SessionStatus status) {
		
		boolean error = false;
	
		System.out.println(emp); 
		
		if(emp.getFirstname().isEmpty())
		{
		result.rejectValue("firstName", "error.firstName");
		error = true;
		}
		
		if(emp.getLastname().isEmpty())
		{
		result.rejectValue("lastName", "error.lastName");
		error = true;
		}
		
		if(emp.getEmail().isEmpty())
		{
		result.rejectValue("email", "error.email");
		error = true;
		}
		
		if(error)
		{
			return "addNew";
		}
		
		
		empmng.create(emp);
		status.setComplete();
		return "redirect:addNew/success";

	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String getSuccess(Model model) {
		return "addSuccess";
	}

}
