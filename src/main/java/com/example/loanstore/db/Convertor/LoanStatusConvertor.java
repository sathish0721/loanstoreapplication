package com.example.loanstore.db.Convertor;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import com.example.loanstore.db.Model.Status;

@Converter
public class LoanStatusConvertor implements AttributeConverter<Status,Integer>
{

	@Override public Integer convertToDatabaseColumn(Status status)
	{
		return status.getCode();
	}

	@Override public Status convertToEntityAttribute(Integer status)
	{
		return Status.fromCode(status);
	}
}
