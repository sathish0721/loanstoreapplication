package com.example.loanstore.db.Convertor;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import com.example.loanstore.db.Model.PaymentMode;
import com.example.loanstore.db.Model.Status;

@Converter
public class PaymentModeConvertor implements AttributeConverter<PaymentMode,Integer>
{
	@Override public Integer convertToDatabaseColumn(PaymentMode payment)
	{
		return payment.getCode();
	}

	@Override public PaymentMode convertToEntityAttribute(Integer payment)
	{
		return PaymentMode.fromCode(payment);
	}
}
