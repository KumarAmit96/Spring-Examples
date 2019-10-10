package com.bean.example.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.example.factorybean.factoryentity.EmployeeFactoryBean;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bean/example/factorybean/config.xml");
		/*
		 * Employee fac_Manager = (Employee) context.getBean("manager");
		 * System.out.println(fac_Manager); Employee fac_Director = (Employee)
		 * context.getBean("manager"); System.out.println(fac_Director);
		 */

		EmployeeFactoryBean fac=(EmployeeFactoryBean)context.getBean("&director");
		System.out.println(fac.getDesignation());
		System.out.println(fac.getObject());
		System.out.println(fac.getObjectType());
		
	}
}
