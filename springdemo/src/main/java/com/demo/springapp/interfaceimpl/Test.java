package com.demo.springapp.interfaceimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("com/demo/springapp/interfaceimpl/config.xml");
		ImplOpenBO impl=(ImplOpenBO)context.getBean("demoCheck");
		impl.printValue();
	}

}
