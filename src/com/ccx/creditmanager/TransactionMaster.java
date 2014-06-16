package com.ccx.creditmanager;

import java.util.Date;

public class TransactionMaster
{
	public final long DEFAULT_ID = -1;
	
	public long		id;
	public String	name;
	public Date		dueDate;

	public TransactionMaster(String aName)
	{
		initialize(DEFAULT_ID, aName, new Date());
	}

	public TransactionMaster(String aName, Date aDueDate)
	{
		initialize(DEFAULT_ID, aName, aDueDate);
	}

	private void initialize(long aId, String aName, Date aDueDate)
	{
		this.id = aId;
		this.name = aName;
		this.dueDate = aDueDate;
	}

}
