package com.utilstatic.java.staticutil;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.utilstatic.java.staticutil.entity.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/utilstatic/java/staticutil/config.xml");
		Employee employee = (Employee) context.getBean("manager");
		System.out.println(employee);

		Employee employees = (Employee) context.getBean("director");
		System.out.println(employees);
	}
}
