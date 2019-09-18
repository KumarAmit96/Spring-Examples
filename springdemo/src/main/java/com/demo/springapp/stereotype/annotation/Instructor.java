package com.demo.springapp.stereotype.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("initiate") // or @Component    -->  By Default it create object with same class name with first letter in small case 
@Scope("prototype")
public class Instructor {
	
	@Value("#{new String('Eagle')}")
	private String name;
	@Value("#{T(java.lang.Math).abs(-95)}")
	private int id;
	@Value("#{list_data}")
	private List<String> topics;
	@Autowired
	private Student student;
	@Value("#{2+4>5}")
	private boolean flag;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Instructor [name=" + name + ", id=" + id + ", topics=" + topics + ", student=" + student + ", flag="
				+ flag + "]";
	}
	
	
}
