package net.customer.com.service;

import java.util.List;

import net.customer.com.entity.Customer;
import net.customer.com.exception.ResourceNotFoundException;
import net.customer.com.repository.CustomRepository;

public class CustomServiceImpl implements CustomerService{
	
	private CustomRepository customRepository;

	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		customRepository.findAll();
		return null;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customRepository.save(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return customRepository.findById(theId).orElseThrow(() -> new ResourceNotFoundException(theId));
	}

	@Override
	public void deleteCustomer(int theId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		customRepository.deleteById(theId);
		
	}

}
