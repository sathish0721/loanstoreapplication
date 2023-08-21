package com.example.loanstore.db.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.loanstore.db.Dto.CustomerDto;
import com.example.loanstore.db.Dto.LenderDto;

public class LoanTest
{
	@Test
	public void loanConstructorTest()
	{
		String loanId = "L1";
		Customer customer = Customer.builder()
			.customerEmail("test1@gmail.com")
			.customerName("test1")
			.customerPassword("test1pass")
			.build();
		Lender lender = Lender.builder()
			.lenderEmail("test1@gmail.com")
			.lenderName("test1")
			.lenderPassword("test1pass")
			.build();

		Long loanAmount = 10000L;
		Long remainingAmount = 5000L;
		Status status = Status.APPROVED;

		Loan loan = Loan.builder()
			.loanId(loanId)
			.customer(customer)
			.lender(lender)
			.loanAmount(loanAmount)
			.remainingAmount(remainingAmount)
			.status(status)
			.build();

		assertEquals(loanId, loan.getLoanId());
		assertEquals(customer, loan.getCustomer());
		assertEquals(lender, loan.getLender());
		assertEquals(loanAmount, loan.getLoanAmount());
		assertEquals(remainingAmount, loan.getRemainingAmount());
		assertEquals(status, loan.getStatus());
	}
}
