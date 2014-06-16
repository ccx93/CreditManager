package com.ccx.creditmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ccx.creditmanager.DatabaseHelper.Master;
import com.ccx.creditmanager.DatabaseHelper.MasterAndTransaction;
import com.ccx.creditmanager.DatabaseHelper.Transactions;

public class DatabaseHandler
{
	SQLiteDatabase	db;
	DatabaseHelper	dbHelper;

	public DatabaseHandler(Context context)
	{
		dbHelper = new DatabaseHelper(context);
	}

	public void open()
	{
		db = dbHelper.getWritableDatabase();
	}

	public void close()
	{
		db.close();
		dbHelper.close();
	}

	public long commitThis(TransactionMaster tm)
	{
		long id;
		// build ContentValue
		ContentValues value = new ContentValues();
		value.put(Master.COLUMN_NAME_NAME, tm.name);
		value.put(Master.COLUMN_NAME_DUE, tm.name);

		// commit and get row index
		id = db.insert(Master.TABLE_NAME, null, value);
		return id;
	}

	public long commitThis(TransactionMaster tm, TransactionItem ti)
	{
		// save to transactions table
		long id;
		// build ContentValue
		ContentValues value = new ContentValues();
		value.put(Transactions.COLLUMN_NAME_DATE, ti.date.getTime());
		value.put(Transactions.COLLUMN_NAME_VALUE, ti.value);

		// commit and get row index
		id = db.insert(Transactions.TABLE_NAME, null, value);

		// save to TransactionAndMaster table
		ContentValues value2 = new ContentValues();
		value2.put(MasterAndTransaction.COLLUMN_NAME_MASTERID, tm.id);
		value2.put(MasterAndTransaction.COLLUMN_NAME_TRANSID, ti.id);

		// commit
		db.insert(MasterAndTransaction.TABLE_NAME, null, value2);

		return id;
	}

	public void deleteThis(TransactionMaster tm)
	{
		long id = tm.id;
		// delete transactions from transactions table
		db.delete(Transactions.TABLE_NAME,
				"_ID IN (" + MasterAndTransaction.getTransactionWithMasterId(id) + ")", null);

		// delete transaction from relationship table
		db.delete(MasterAndTransaction.TABLE_NAME, MasterAndTransaction.COLLUMN_NAME_MASTERID + "="
				+ id, null);

		// delete from table master
		db.delete(Transactions.TABLE_NAME, "_ID=" + id, null);
	}

	public void deleteThis(TransactionItem ti)
	{
		long id = ti.id;
		// delete transactions from transactions table
		db.delete(Transactions.TABLE_NAME, "_ID=" + id, null);

		// delete transaction from relationship table
		db.delete(MasterAndTransaction.TABLE_NAME, MasterAndTransaction.COLLUMN_NAME_TRANSID + "="
				+ id, null);
	}

	public void updateThis(TransactionItem ti)
	{
		// build ContentValues from new transaction
		ContentValues value = new ContentValues();
		value.put(Transactions.COLLUMN_NAME_DATE, ti.date.getTime());
		value.put(Transactions.COLLUMN_NAME_VALUE, ti.value);

		// update to db
		db.update(Transactions.TABLE_NAME, value, "_ID=" + ti.id, null);
	}

	public void updateThis(TransactionMaster tm)
	{
		// build ContentValues from new master
		ContentValues value = new ContentValues();
		value.put(Master.COLUMN_NAME_NAME, tm.name);
		value.put(Master.COLUMN_NAME_DUE, tm.dueDate.getTime());

		// update to db
		db.update(Master.TABLE_NAME, value, "_ID=" + tm.id, null);
	}
}
