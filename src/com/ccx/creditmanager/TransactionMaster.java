package com.ccx.creditmanager;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.annotation.SuppressLint;

public class TransactionMaster
{
	public final long	DEFAULT_ID		= -1;
	public final int	DEFAULT_DATE	= 1;

	public long			id;
	public String		name;
	public int			dueDate;

	public TransactionMaster(String aName)
	{
		initialize(DEFAULT_ID, aName, DEFAULT_DATE);
	}

	public TransactionMaster(String aName, int aDueDate)
	{
		initialize(DEFAULT_ID, aName, aDueDate);
	}

	public TransactionMaster(long id, String aName, int aDueDate)
	{
		initialize(id, aName, aDueDate);
	}

	private void initialize(long aId, String aName, int aDueDate)
	{
		this.id = aId;
		this.name = aName;
		this.dueDate = aDueDate;
	}

	@SuppressLint("SimpleDateFormat")
	public String getNextDue()
	{
		// parse date from integer
		Calendar cd = Calendar.getInstance();
		cd.set(Calendar.DATE, dueDate);
		cd.add(Calendar.MONTH, 1); // fast forward by 1 month
		
		SimpleDateFormat sdf = new SimpleDateFormat("DD MMMM"); // TODO use locale
		return sdf.format(cd.getTime());
	}
}
