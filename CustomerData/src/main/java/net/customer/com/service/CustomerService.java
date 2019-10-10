package net.customer.com.service;

import java.util.List;

import net.customer.com.entity.Customer;
import net.customer.com.exception.ResourceNotFoundException;

public interface CustomerService {
	
	public List<Customer> getCustomer();
	
	public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId) throws ResourceNotFoundException;

    public void deleteCustomer(int theId) throws ResourceNotFoundException;
	

}
