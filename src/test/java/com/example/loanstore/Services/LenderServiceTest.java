package com.example.loanstore.Services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.loanstore.db.Dto.CustomerDto;
import com.example.loanstore.db.Dto.LenderDto;
import com.example.loanstore.db.Model.Customer;
import com.example.loanstore.db.Model.Lender;
import com.example.loanstore.db.Repository.CustomerRepository;
import com.example.loanstore.db.Repository.LenderRepository;

public class LenderServiceTest
{
	LenderRepository lenderRepository;
	LenderService lenderService;

	@BeforeEach
	public void setUp() {
		lenderRepository = mock(LenderRepository.class);
		lenderService =  mock(LenderService.class);
	}

	@Test
	public void signUpLenderTest()
	{
		LenderDto lenderDto = LenderDto.builder()
			.lenderName("test1")
			.lenderEmail("test@test.com")
			.lenderPassword("test@1123")
			.build();
		when(lenderService.signUpLender(lenderDto)).thenReturn(Optional.empty());
	}
	@Test
	public void loginlenderTest()
	{
		LenderDto lenderDto = LenderDto.builder()
			.lenderEmail("test@test.com")
			.lenderPassword("test@1123")
			.build();

		Lender lender = Lender.builder()
			.lenderName("test1")
			.lenderEmail("test@test.com")
			.lenderPassword("test@1123")
			.build();
		when(lenderService.loginLender(lenderDto)).thenReturn(lender);
	}
}
