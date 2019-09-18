package com.demo.springapp.springorm.product.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.demo.springapp.springorm.product.dao.ProductDao;
import com.demo.springapp.springorm.product.entity.Product;

@Component("productDao")
public class ProductDaoImpl implements ProductDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public int create(Product product) {
		Integer result = (Integer) hibernateTemplate.save(product);
		return result;
	}

	@Transactional
	public void update(Product product) {
		hibernateTemplate.update(product);
	}

	@Transactional
	public void delete(Product product) {
		hibernateTemplate.delete(product);
	}

	public Product find(int id) {
		Product product = hibernateTemplate.get(Product.class, id);
		return product;
	}

	public List<Product> findAll() {
		List<Product> list = hibernateTemplate.loadAll(Product.class);
		return list;
	}

}
