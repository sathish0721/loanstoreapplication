package com.example.loanstore.db.Model.CustomeIdGenerator;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class PaymentCustomIdGenerator implements IdentifierGenerator
{
	private String prefix = "P";
	private int count = 1;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException
	{
		return prefix + count++;
	}
}
