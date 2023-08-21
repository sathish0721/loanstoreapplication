package com.example.loanstore.Services;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanstore.db.Convertor.DateToMilliSecondConvertor;
import com.example.loanstore.db.Dto.LoanDto;
import com.example.loanstore.db.Model.Loan;
import com.example.loanstore.db.Model.Status;
import com.example.loanstore.db.Repository.LoanRepository;

@Service
public class LoanService
{
	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private ModelMapper modelMapper;

	public Loan convertLenderDtoToLender(LoanDto loanDto)
	{
		return modelMapper.map(loanDto,Loan.class);
	}

	public Optional<Loan> requestLoanToLender(LoanDto loanDto) throws ParseException
	{
		Loan loan = convertLenderDtoToLender(loanDto);
		loan.setStatus(Status.fromCode(1));
		Long date = DateToMilliSecondConvertor.dateToMilliSecondConvertor(loanDto.getDueDate());
		loan.setDueDateForLoan(date);
		return Optional.of(loanRepository.save(loan));
	}
	public Optional<Loan> acceptOrRejectLoan(String loanId,int status)
	{
		Optional<Loan> loanRow = loanRepository.findById(loanId);
		Loan loan = loanRow.get();
		loan.setStatus(Status.fromCode(status));
		return Optional.of(loanRepository.save(loan));
	}
	public List<Loan> showAllLoanForLender(String lenderId)
	{
		return loanRepository.findAllById(Arrays.asList(lenderId));
	}
}
