package com.example.loanstore.db.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.example.loanstore.db.Model.Customer;
import com.example.loanstore.db.Model.Lender;
import com.example.loanstore.db.Model.Status;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoanDto
{
	private String loanId;
	private Customer customer;
	private Lender lender;
	private Long loanAmount;
	private Long remainingAmount;
	private Long dueDateForLoan;
	private int interestAmount;
	private Status status;
	private String dueDate;
}
