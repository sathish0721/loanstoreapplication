package com.example.loanstore.db.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LenderTest
{
	@Test
	public void lenderConstructorTest()
	{
		String id = "LEN1";
		String username = "testLEN1";
		String email = "testLEN1@test.com";
		Lender lender= Lender.builder()
			.lenderId(id)
			.lenderName(username)
			.lenderEmail(email)
			.build();

		assertEquals(id, lender.getLenderId());
		assertEquals(username, lender.getLenderName());
		assertEquals(email, lender.getLenderEmail());
	}
}
