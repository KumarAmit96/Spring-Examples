package com.springstatic.example.springstaticexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springstatic.example.springstaticexample.wrapper.EmployeeWrapper;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springstatic/example/springstaticexample/config.xml");
		EmployeeWrapper employeeWrapper = (EmployeeWrapper) context.getBean("employeeWrapper");
		System.out.println(employeeWrapper.getDirector());
		System.out.println(employeeWrapper.getManager());
	}
}
