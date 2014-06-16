package depecrated;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.ccx.creditmanager.TransactionItem;

import android.util.LongSparseArray;

public class LinkedMappedList implements MappedList
{
	private LongSparseArray<Integer>	map;
	private List<TransactionItem>		list;

	public LinkedMappedList()
	{
		this.map = new LongSparseArray<Integer>();
		this.list = new LinkedList<TransactionItem>();
	}

	@Override
	public void add(TransactionItem transactionItem)
	{
		int currentLocation = this.list.size();

		// add to list and to map
		this.list.add(currentLocation, transactionItem);
		this.map.put(transactionItem.id, currentLocation);
	}

	@Override
	public void remove(TransactionItem transactionItem)
	{
		remove(transactionItem.id);
	}

	@Override
	public void remove(long transcationId)
	{
		// remove from list then from map
		// remove does not delete the list in order to handle mapping easily
		this.list.set(this.map.get(transcationId), null);
		this.map.remove(transcationId);
	}

	@Override
	public void refreshMap()
	{
		// clear map first
		this.map.clear();

		// readd every element in list
		int location = 0;
		for (Iterator<TransactionItem> i = this.list.iterator(); i.hasNext();)
		{
			TransactionItem ti = i.next();
			if (ti != null)
			{
				// check whether current element is null (removed)
				this.map.put(ti.id, location);
			}
			location++;
		}
	}

	@Override
	public void parseFromList(List<TransactionItem> list)
	{
		// clear current list first
		clear();

		// set list to transaction master's list and refresh mapping
		this.list = list;
		refreshMap();
	}

	@Override
	public void clear()
	{
		// clears map and list
		this.list.clear();
		this.map.clear();
	}

	@Override
	public TransactionItem getItem(int location)
	{
		return this.list.get(location);
	}

	@Override
	public TransactionItem getItem(long transactionId)
	{
		int location = this.map.get(transactionId, -1);
		if (location == -1)
			// key not found
			return null;
		else
			// key found
			return this.list.get(this.map.get(transactionId));
	}

}
