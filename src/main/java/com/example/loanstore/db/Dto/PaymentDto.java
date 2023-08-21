package com.example.loanstore.db.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.example.loanstore.db.Model.Customer;
import com.example.loanstore.db.Model.Loan;
import com.example.loanstore.db.Model.PaymentMode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDto
{
	private String paymentId;
	private Loan loan;
	private Customer customer;
	private PaymentMode paymentMode;
	private Long paymentAmount;
	private Long remainingAmount;
}
