package com.demo.springapp.springstandalone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/demo/springapp/springstandalone/config.xml");
		  DemoStandAlone demoData = (DemoStandAlone) applicationContext.getBean(DemoStandAlone.class);
		  System.out.println(demoData.getName());
		  System.out.println(demoData.getSubject());
		  System.out.println(demoData.toString());

	}

}
