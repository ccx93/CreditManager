package com.ccx.creditmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper
{

	public DatabaseHandler(Context context)
	{
		super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(DatabaseContract.TransactionMaster.CREATE_TABLE);
		db.execSQL(DatabaseContract.Transactions.CREATE_TABLE);
		db.execSQL(DatabaseContract.MasterAndTransaction.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// no plan to upgradeDB
	}
}
