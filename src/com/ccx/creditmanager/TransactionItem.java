package com.ccx.creditmanager;

import java.util.Date;

public class TransactionItem
{
	public static final long	DEFAULT_ID	= -1;
	public long					id;
	public long					value;
	public Date					date;

	public TransactionItem()
	{
		initialize(0, new Date());
	}

	public TransactionItem(long aValue)
	{
		initialize(aValue, new Date());
	}

	public TransactionItem(long aValue, Date aDate)
	{
		initialize(aValue, aDate);
	}

	private void initialize(long aValue, Date aDate)
	{
		this.id = DEFAULT_ID;
		this.value = aValue;
		this.date = aDate;
	}

	@Override
	public String toString()
	{
		// TODO
		return null;

	}
}
