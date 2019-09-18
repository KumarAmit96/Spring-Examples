package com.aop.spring.springjavaconfig;

import org.springframework.stereotype.Component;

@Component
public class DAO {

	public void create()
	{
		System.out.println("Created the Object....");
	}
	
}
