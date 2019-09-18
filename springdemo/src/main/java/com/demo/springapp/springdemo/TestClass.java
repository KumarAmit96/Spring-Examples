package com.demo.springapp.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {

	public static void main(String[] args) {

		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("com/demo/springapp/springdemo/config.xml");
		DemoData demoData=(DemoData)applicationContext.getBean(DemoData.class);
		System.out.println(demoData.getAge()+"  "+demoData.getName());
		System.out.println(demoData.toString());
	}

}
