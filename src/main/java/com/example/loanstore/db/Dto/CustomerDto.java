package com.example.loanstore.db.Dto;

import jakarta.persistence.Column;
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
public class CustomerDto
{
	private String customerId;
	private String customerName;
	private String customerEmail;
	private String customerPassword;
}
