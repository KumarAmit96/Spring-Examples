package com.demo.springapp.stereotype.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/demo/springapp/stereotype/annotation/config.xml");
		  Instructor instructor=(Instructor)applicationContext.getBean("initiate");
		  System.out.println(instructor);
		  
		  Instructor instructor2=(Instructor)applicationContext.getBean("initiate");
		  System.out.println(instructor2);
	}

}
