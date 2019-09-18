package com.aop.spring.springjavaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DAOConfig.class)
public class SpringConfig {

	@Bean(initMethod="init",destroyMethod="destroy")
	//@Scope("Prototype") -> Test the scope of bean 
	public Service service()
	{
		return new Service();
	}
	
}
