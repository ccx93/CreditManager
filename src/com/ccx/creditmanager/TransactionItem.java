package com.ccx.creditmanager;

import java.util.Date;

public class TransactionItem
{
	public static final long	DEFAULT_ID	= -1;
	long						id;
	long						value;
	Date						date;

	public TransactionItem()
	{
		construct(0, new Date());
	}

	public TransactionItem(long aValue)
	{
		construct(aValue, new Date());
	}

	public TransactionItem(long aValue, Date aDate)
	{
		construct(aValue, aDate);
	}

	private void construct(long aValue, Date aDate)
	{
		this.id = DEFAULT_ID;
		this.value = aValue;
		this.date = aDate;
	}

	// GETTERS AND SETTERS =========
	public long getId()
	{
		return id;
	}

	public void setId(long id)
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
