package com.example.loanstore.db.Model;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.loanstore.db.Dto.CustomerDto;
import com.example.loanstore.db.Model.Customer;

public class CustomerTest
{
	@Test
	public void customerConstructorTest()
	{
		String id = "C1";
		String username = "testC1";
		String email = "testC1@test.com";
		Customer customer= Customer.builder()
			.customerId(id)
			.customerName(username)
			.customerEmail(email)
			.build();

		assertEquals(id, customer.getCustomerId());
		assertEquals(username, customer.getCustomerName());
		assertEquals(email, customer.getCustomerEmail());
	}
}

