package com.ccx.creditmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{
	SQLiteDatabase db;
	
	public DatabaseHandler(Context context)
	{
		super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		this.db = db;
		db.execSQL(DatabaseContract.TransactionMaster.CREATE_TABLE);
		db.execSQL(DatabaseContract.Transactions.CREATE_TABLE);
		db.execSQL(DatabaseContract.MasterAndTransaction.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// no plan to upgradeDB
	}
	
	public long commitThis(TransactionMaster tm)
	{
		long id;
		// build ContentValue
		ContentValues value = new ContentValues();
		value.put(DatabaseContract.TransactionMaster.COLUMN_NAME_NAME, tm.name);
		value.put(DatabaseContract.TransactionMaster.COLUMN_NAME_DUE, tm.name);
		
		// commit and get row index
		id = db.insert(DatabaseContract.TransactionMaster.TABLE_NAME, null, null);
		return id;
	}
}
