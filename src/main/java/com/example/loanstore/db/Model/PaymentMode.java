package com.example.loanstore.db.Model;

public enum PaymentMode
{
	CARD(1),
	CASH(2),
	UPI(3);

	private final Integer payment;
	PaymentMode(Integer payment)
	{
		this.payment=payment;
	}
	public Integer getCode()
	{
		return payment;
	}
	public static PaymentMode fromCode(Integer code) {
		for (PaymentMode payment : PaymentMode.values()) {
			if (payment.getCode() == code) {
				return payment;
			}
		}
		throw new IllegalArgumentException("Unknown payment code: " + code);
	}

}
