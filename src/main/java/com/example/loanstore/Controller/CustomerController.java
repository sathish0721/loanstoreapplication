package com.example.loanstore.Controller;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loanstore.Services.CustomerService;
import com.example.loanstore.Services.LoanService;
import com.example.loanstore.Services.PaymentService;
import com.example.loanstore.db.Dto.CustomerDto;
import com.example.loanstore.db.Dto.LoanDto;
import com.example.loanstore.db.Dto.PaymentDto;
import com.example.loanstore.db.Model.Customer;
import com.example.loanstore.db.Model.Loan;
import com.example.loanstore.db.Model.Payment;

@RestController
@RequestMapping("/api/customer")
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	@Autowired
	private LoanService loanService;

	@Autowired
	private PaymentService paymentService;

	@PostMapping()
	public String signUpCustomer(@RequestBody CustomerDto customerDto)
	{
		Optional<Customer> signUpCustomer = customerService.signUpCustomer(customerDto);
		if(signUpCustomer.isEmpty())
		{
			return "customer.signup.failed";
		}
		return "customer.signup.sucess";
	}
	@GetMapping()
	public Customer logInCustomer(@RequestBody CustomerDto customerDto)
	{
		Customer customer = customerService.logInCustomer(customerDto);
		return customer;
	}

	@Transactional
	@PostMapping("/requestLoan")
	public String requestLoanToLender(@RequestBody LoanDto loanDto) throws ParseException
	{
		Optional<Loan> requestLoan = loanService.requestLoanToLender(loanDto);
		if(!requestLoan.isEmpty())
		{
			return "customer.loan.submitted.approval";
		}
		return "customer.loan.creation.failure";
	}

	@Transactional
	@PostMapping("/makePayment")
	public  String makePaymentForTheLoan(@RequestBody PaymentDto paymentDto)
	{
		Optional<Loan> makePayment = paymentService.makePaymentForTheLoan(paymentDto);
		if(!makePayment.isEmpty())
		{
			return "customer.payment.sucess";
		}
		return "customer.payment.failed";
	}
}
