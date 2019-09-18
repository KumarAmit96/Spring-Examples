package com.aop.spring.springjavaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
	
	@Autowired
	DAO dao;
	
	public void init()
	{
		System.out.println("Inside init method....");
	}
	
	public void destroy()
	{
		System.out.println("Inside destroy method....");
	}
	
	public void save()
	{
		dao.create();
	}

}
