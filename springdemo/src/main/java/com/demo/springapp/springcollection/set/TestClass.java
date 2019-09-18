package com.demo.springapp.springcollection.set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClass {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/demo/springapp/springcollection/set/config.xml");
		  DemoSet demoData = (DemoSet) applicationContext.getBean(DemoSet.class);
		  System.out.println(demoData.getName());
		  System.out.println(demoData.getSubject());
		  System.out.println(demoData.toString());

	}

}
