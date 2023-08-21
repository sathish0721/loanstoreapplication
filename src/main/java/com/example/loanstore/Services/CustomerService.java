package com.example.loanstore.Services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanstore.db.Dto.CustomerDto;
import com.example.loanstore.db.Model.Customer;
import com.example.loanstore.db.Model.Payment;
import com.example.loanstore.db.Repository.CustomerRepository;

@Service
public class CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	private Customer convertCustomerDtoToCustomer(CustomerDto customerDto)
	{
		return modelMapper.map(customerDto,Customer.class);
	}
	public Optional<Customer> signUpCustomer(CustomerDto customerDto)
	{
		Customer customer = convertCustomerDtoToCustomer(customerDto);
//		if(!customerRepository.existsByEmail(customer.getCustomerEmail()))
//		{
			if(customer.getCustomerName().isEmpty())
			{
				return Optional.empty();
			}
			return Optional.of(customerRepository.save(customer));
//		}
//		return Optional.empty();
	}
	public Customer logInCustomer(CustomerDto customerDto)
	{
		Customer customer = convertCustomerDtoToCustomer(customerDto);
		return customerRepository.loginCustomer(customer.getCustomerEmail(),customer.getCustomerPassword());
	}

}
