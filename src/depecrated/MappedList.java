package depecrated;

import java.util.List;

import com.ccx.creditmanager.TransactionItem;


public interface MappedList
{
	public void add(TransactionItem transactionItem);

	public void remove(TransactionItem transactionItem);
	
	public void remove(long transcationId);

	public void refreshMap();

	public void clear();

	public void parseFromList(List<TransactionItem> list);

	public TransactionItem getItem(int location);
	
	public TransactionItem getItem(long t);
}
