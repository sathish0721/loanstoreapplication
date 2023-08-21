package com.example.loanstore.db.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PaymentTest
{
	@Test
	public void paymentConstructorTest()
	{
		String paymentId = "P1";
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
		PaymentMode paymentMode = PaymentMode.CARD;
		Long paymentAmount = 10000L;

		Payment payment = Payment.builder()
			.paymentId(paymentId)
			.paymentAmount(paymentAmount)
			.paymentMode(paymentMode)
			.customer(customer)
			.loan(loan)
			.build();

		assertEquals(paymentId, payment.getPaymentId());
		assertEquals(paymentAmount, payment.getPaymentAmount());
		assertEquals(paymentMode, payment.getPaymentMode());
		assertEquals(customer, payment.getCustomer());
		assertEquals(loan, payment.getLoan());
	}

}
