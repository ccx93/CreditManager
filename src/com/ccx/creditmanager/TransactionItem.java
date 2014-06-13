package com.ccx.creditmanager;

import java.util.Date;
import java.util.UUID;

public class TransactionItem
{
	UUID	id;
	long	value;
	Date	date;

	public TransactionItem()
	{
		this.id = UUID.randomUUID();
		this.value = 0;
		this.date = new Date();
	}

	public TransactionItem(long aValue)
	{
		this.id = UUID.randomUUID();
		this.value = aValue;
		this.date = new Date();
	}

	public TransactionItem(long aValue, Date aDate)
	{
		this.id = UUID.randomUUID();
		this.value = aValue;
		this.date = aDate;
	}

	public UUID getId()
	{
		return id;
	}

	public void setId(UUID id)
	{
		this.id = id;
	}

	public long getValue()
	{
		return value;
	}

	public void setValue(long value)
	{
		this.value = value;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
}
