package com.example.loanstore.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loanstore.Services.LenderService;
import com.example.loanstore.Services.LoanService;
import com.example.loanstore.db.Dto.LenderDto;
import com.example.loanstore.db.Dto.LoanDto;
import com.example.loanstore.db.Model.Lender;
import com.example.loanstore.db.Model.Loan;
import com.example.loanstore.db.Model.Status;

@RestController
@RequestMapping("/api/lender")
public class LenderController
{
	@Autowired
	private LenderService lenderService;

	@Autowired
	private LoanService loanService;

	@PostMapping()
	public String signUpLender(@RequestBody LenderDto lenderDto)
	{
		Optional<Lender> signUpCustomer = lenderService.signUpLender(lenderDto);
		if(signUpCustomer.isEmpty())
		{
			return "lender.signup.failed";
		}
		return "lender.signup.sucess";
	}
	@GetMapping()
	public Lender loginLender(@RequestBody LenderDto lenderDto)
	{
		Lender lender = lenderService.loginLender(lenderDto);
		return lender;
	}
	@Transactional
	@PutMapping("/{loanId}/acceptOrRejectLoan/{status}")
	public String acceptOrRejectLoan(@PathVariable("loanId") String loanId,@PathVariable("status") int status)
	{
		Optional<Loan> acceptOrReject = loanService.acceptOrRejectLoan(loanId,status);
		if(!acceptOrReject.isEmpty())
		{
			return "lender.loan.acceptorreject.sucess";
		}
		return "lender.loan.acceptorreject.failure";
	}
	@GetMapping("/loans/{id}")
	public List<Loan> showAllLoanForLender(@PathVariable("id") String lenderId)
	{
		return loanService.showAllLoanForLender(lenderId);
	}

}
