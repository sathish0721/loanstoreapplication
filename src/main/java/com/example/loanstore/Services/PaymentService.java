package com.example.loanstore.Services;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanstore.db.Dto.PaymentDto;
import com.example.loanstore.db.Model.Loan;
import com.example.loanstore.db.Model.Payment;
import com.example.loanstore.db.Repository.LoanRepository;
import com.example.loanstore.db.Repository.PaymentRepository;

@Service
public class PaymentService
{
	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private ModelMapper modelMapper;

	public Payment convertPaymentDtoToPayment(PaymentDto paymentDto)
	{
		return modelMapper.map(paymentDto,Payment.class);
	}
	public Optional<Loan> makePaymentForTheLoan(PaymentDto paymentDto)
	{
		Payment payment = convertPaymentDtoToPayment(paymentDto);
		Optional<Loan> loanObj = loanRepository.findById(payment.getLoan().getLoanId());
		Loan loan = loanObj.get();
		long currentTime = System.currentTimeMillis();
		if(loan.getRemainingAmount() >= payment.getPaymentAmount() &&
				loan.getDueDateForLoan() >= currentTime)
		{
			Long remaingAmount = loan.getRemainingAmount()-payment.getPaymentAmount();
			loan.setRemainingAmount(remaingAmount);
			paymentRepository.save(payment);
			return Optional.of(loanRepository.save(loan));
		}
		return Optional.empty();
	}
}
