package net.customer.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.customer.com.entity.Customer;

@Repository("customRepository")
public interface CustomRepository extends JpaRepository<Customer, Integer> {

}
