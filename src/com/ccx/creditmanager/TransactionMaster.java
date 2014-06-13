package com.ccx.creditmanager;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TransactionMaster
{
	UUID					id;
	String					name;
	List<TransactionItem>	list;
	Map<UUID, Integer>		transLoc;

	public TransactionMaster(String aName)
	{
		this.id = UUID.randomUUID();
		this.name = aName;
		this.list = new LinkedList<TransactionItem>();
	}
	
	public void addTransaction (TransactionItem ti)
	{
		this.list.add(ti);
		this.transLoc.put(ti.id, this.list.size()-1);
	}
	
	public void clearList()
	{
		this.list.clear();
	}
	
	public TransactionItem getTransaction (UUID id)
	{
		TransactionItem ti = this.list.get(transLoc.get(id));
		return ti;
	}

}
