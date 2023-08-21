package com.example.loanstore.db.Model;

public enum Status
{
	PENDING(1),
	APPROVED(2),
	REJECTED(3) ;

	private final Integer status;
	Status(Integer status)
	{
		this.status = status;
	}
	public int getCode() {
		return status;
	}

	public static Status fromCode(Integer code) {
		for (Status status : Status.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Unknown Status code: " + code);
	}
}
