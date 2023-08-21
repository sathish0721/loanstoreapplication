package com.example.loanstore.db.Model.CustomeIdGenerator;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomerCustomeIdGenerator implements IdentifierGenerator
{
	private String prefix = "C";
	private AtomicInteger sequence = new AtomicInteger(0);

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException
	{
		return prefix + sequence.incrementAndGet();
	}
}
