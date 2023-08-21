package com.example.loanstore.Services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanstore.db.Dto.LenderDto;
import com.example.loanstore.db.Model.Lender;
import com.example.loanstore.db.Model.Loan;
import com.example.loanstore.db.Repository.LenderRepository;

@Service
public class LenderService
{
	@Autowired
	private LenderRepository lenderRepository;

	@Autowired
	private ModelMapper modelMapper;

	private Lender convertLenderDtoToLender(LenderDto lenderDto)
	{
		return modelMapper.map(lenderDto,Lender.class);
	}

	public Optional<Lender> signUpLender(LenderDto lenderDto)
	{
		Lender lender = convertLenderDtoToLender(lenderDto);
//		if(!lenderRepository.existsByEmail(lender.getLenderEmail()))
//		{
			if(lender.getLenderName().isEmpty())
			{
				return Optional.empty();
			}
			return Optional.of(lenderRepository.save(lender));
//		}
//		return Optional.empty();
	}
	public Lender loginLender(LenderDto lenderDto)
	{
		Lender lender = convertLenderDtoToLender(lenderDto);
		return lenderRepository.loginLender(lender.getLenderEmail(),lender.getLenderPassword());
	}
}
