package com.aop.spring.springjavaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Service dao = (Service) context.getBean(Service.class);
		dao.save();
		context.close();
        // AnnotationConfigApplicationContext provides registration for many classes by providing context.register(XYZ.class)
	}

}
