package com.example.loanstore.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.loanstore.Services.LenderService;
import com.example.loanstore.Services.LoanService;
import com.example.loanstore.db.Dto.LenderDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(LenderController.class)
public class LenderControllerTest
{
	@MockBean
	private LenderService lenderService;
	@MockBean
	private LoanService loanService;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Test
	void signUpLenderTest() throws Exception
	{
		LenderDto lenderDto = LenderDto.builder()
			.lenderEmail("test1@gmail.com")
			.lenderName("test1")
			.lenderPassword("test1pass")
			.build();

		String userJson = objectMapper.writeValueAsString(lenderDto);
		mockMvc.perform(post("/api/lender").contentType(MediaType.APPLICATION_JSON)
				.content(userJson))
			.andExpect(status().isOk())
			.andDo(print());
	}
	@Test
	void loginLenderTest() throws Exception
	{
		LenderDto lenderDto = LenderDto.builder()
			.lenderEmail("test1@gmail.com")
			.lenderPassword("test1pass")
			.build();

		String userJson = objectMapper.writeValueAsString(lenderDto);
		mockMvc.perform(get("/api/lender").contentType(MediaType.APPLICATION_JSON)
				.content(userJson))
			.andExpect(status().isOk())
			.andDo(print());
	}
	@Test
	void acceptOrRejectLoanTest() throws Exception
	{
		String loanId = "L1";
		String status = "3";

		mockMvc.perform(put("/api/lender/{loanId}/acceptOrRejectLoan/{status}",loanId,status)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andDo(print());
	}
	@Test
	void showAllLoanForLenderTest() throws Exception
	{
		String lenderId = "LEN1";

		mockMvc.perform(get("/api/lender/loans/{id}",lenderId)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andDo(print());
	}
}
