package com.example.loanstore.db.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LenderDto
{
	private String lenderId;
	private String lenderName;
	private String lenderEmail;
	private String lenderPassword;
}
