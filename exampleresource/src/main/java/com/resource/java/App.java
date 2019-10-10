package com.resource.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.resource.java.entity.CustomResourceLoader;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/resource/java/config.xml");
		CustomResourceLoader customReader = (CustomResourceLoader) context.getBean("customResourceLoader");
		System.out.println(customReader.getResource());
		// customReader.showResourceData(); Define for 1st type

	}
}
