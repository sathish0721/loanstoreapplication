package com.example.loanstore.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.loanstore.Services.CustomerService;
import com.example.loanstore.Services.LoanService;
import com.example.loanstore.Services.PaymentService;
import com.example.loanstore.db.Dto.CustomerDto;
import com.example.loanstore.db.Dto.LoanDto;
import com.example.loanstore.db.Dto.PaymentDto;
import com.example.loanstore.db.Model.Customer;
import com.example.loanstore.db.Model.Lender;
import com.example.loanstore.db.Model.Loan;
import com.example.loanstore.db.Model.PaymentMode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest
{
	@MockBean
	private CustomerService customerService;

	@MockBean
	private LoanService loanService;

	@MockBean
	private PaymentService paymentService;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void signUpCustomerTest() throws Exception
	{
		CustomerDto customerDto = CustomerDto.builder()
			.customerEmail("test1@gmail.com")
			.customerName("test1")
			.customerPassword("test1pass")
			.build();

		String userJson = objectMapper.writeValueAsString(customerDto);
		mockMvc.perform(post("/api/customer").contentType(MediaType.APPLICATION_JSON)
				.content(userJson))
				.andExpect(status().isOk())
				.andDo(print());
	}
	@Test
	void loginCustomerTest() throws Exception
	{
		CustomerDto customerDto = CustomerDto.builder()
			.customerEmail("test1@gmail.com")
			.customerPassword("test1pass")
			.build();

		String userJson = objectMapper.writeValueAsString(customerDto);
		mockMvc.perform(get("/api/customer").contentType(MediaType.APPLICATION_JSON)
				.content(userJson))
			.andExpect(status().isOk())
			.andDo(print());
	}
	@Test
	void requestLoanTest() throws Exception
	{
		Customer customer = Customer.builder()
			.customerId("C1")
			.build();
		Lender lender = Lender.builder()
			.lenderId("LEN1")
			.build();
		LoanDto loanDto = LoanDto.builder()
			.lender(lender)
			.customer(customer)
			.loanAmount(20000L)
			.dueDate("2023/10/21")
			.build();

		String userJson = objectMapper.writeValueAsString(loanDto);
		mockMvc.perform(post("/api/customer/requestLoan").contentType(MediaType.APPLICATION_JSON)
				.content(userJson))
				.andExpect(status().isOk())
				.andDo(print());

	}
	@Test
	void makePaymentTest() throws Exception
	{
		Customer customer = Customer.builder()
			.customerId("C1")
			.build();
		Loan loan = Loan.builder()
			.loanId("L1")
			.build();

		PaymentDto paymentDto = PaymentDto.builder()
			.customer(customer)
			.loan(loan)
			.paymentMode(PaymentMode.fromCode(1))
			.paymentAmount(10000L)
			.build();

		String userJson = objectMapper.writeValueAsString(paymentDto);
		mockMvc.perform(post("/api/customer/makePayment").contentType(MediaType.APPLICATION_JSON)
				.content(userJson))
			.andExpect(status().isOk())
			.andDo(print());

	}
}
