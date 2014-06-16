package com.ccx.creditmanager;

import java.util.Date;

public class TransactionMaster
{
	long		id;
	String		name;
	Date		dueDate;
	MappedList	list;

	public TransactionMaster(String aName)
	{
		this.name = aName;
		this.list = new LinkedMappedList();
	}

	public void clearList()
	{
		this.list.clear();
	}

	// TRANSACTION MANIPULATION ===============
	public void addTransaction(TransactionItem ti)
	{
		this.list.add(ti);
	}

	public void removeTransaction(TransactionItem ti)
	{
		this.list.remove(ti);
	}

	public TransactionItem getTransaction(long id)
	{
		return this.list.getItem(id);
	}

}
