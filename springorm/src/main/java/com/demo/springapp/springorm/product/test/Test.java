package com.demo.springapp.springorm.product.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.springapp.springorm.product.dao.ProductDao;
import com.demo.springapp.springorm.product.entity.Product;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/demo/springapp/springorm/product/test/config.xml");
		ProductDao productDao=(ProductDao) context.getBean("productDao");
		/*
		 * Product product=new Product(); product.setId(1); product.setName("IphoneX");
		 * product.setPrice(75000); product.setDesc("Awesome product....");
		 * //productDao.create(product); //productDao.update(product);
		 * //productDao.delete(product);
		 */
		
		//Product product=productDao.find(1);
		List<Product> product=productDao.findAll();
		for(Product p:product)
		System.out.println("The deleted item is:" +p.toString());
		
	}

}
