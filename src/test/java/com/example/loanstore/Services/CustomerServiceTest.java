package com.example.loanstore.Services;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.loanstore.db.Dto.CustomerDto;
import com.example.loanstore.db.Model.Customer;
import com.example.loanstore.db.Repository.CustomerRepository;

//@WebMvcTest(CustomerService.class)
public class CustomerServiceTest
{
	CustomerRepository customerRepository;
	CustomerService customerService;

	@BeforeEach
	public void setUp() {
		customerRepository = mock(CustomerRepository.class);
		customerService =  mock(CustomerService.class);
	}

	@Test
	public void signUpCustomerTest()
	{
		CustomerDto customerDto = CustomerDto.builder()
			.customerName("test1")
			.customerEmail("test@test.com")
			.customerPassword("test@1123")
			.build();
		when(customerService.signUpCustomer(customerDto)).thenReturn(Optional.empty());
	}
	@Test
	public void loginCustomerTest()
	{
		CustomerDto customerDto = CustomerDto.builder()
			.customerEmail("test@test.com")
			.customerPassword("test@1123")
			.build();

		Customer customer = Customer.builder()
			.customerEmail("test@test.com")
			.customerPassword("test@1123")
			.build();
		when(customerService.logInCustomer(customerDto)).thenReturn(customer);
	}
}
