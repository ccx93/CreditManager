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
		initialize(DEFAULT_ID, 0, new Date());
	}

	public TransactionItem(long aValue)
	{
		initialize(DEFAULT_ID, aValue, new Date());
	}

	public TransactionItem(long aValue, Date aDate)
	{
		initialize(DEFAULT_ID, aValue, aDate);
	}

	public TransactionItem(long aId, long aValue, Date aDate)
	{
		initialize(aId, aValue, aDate);
	}
	
	private void initialize(long aId, long aValue, Date aDate)
	{
		this.id = aId;
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
