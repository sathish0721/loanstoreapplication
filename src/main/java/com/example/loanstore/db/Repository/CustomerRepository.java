package com.example.loanstore.db.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.loanstore.db.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>
{
//	public Boolean existsByEmail(String customerEmail);

	@Query(value = "Select * from customer where customerEmail=? and customerPassword=?" ,nativeQuery = true)
	public Customer loginCustomer(String customerEmail,String customerPassword);
}
