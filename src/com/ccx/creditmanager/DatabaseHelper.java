package com.ccx.creditmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;

public class DatabaseHelper extends SQLiteOpenHelper
{
	public static final String	DATABASE_NAME		= "CreditMaster";
	public static final int		DATABASE_VERSION	= 1;

	private static final String	TEXT_TYPE			= " TEXT";
	private static final String	INTEGER_TYPE		= " INTEGER";
	private static final String	SEPARATOR			= ",";

	private static final String	ROW_LIMIT			= "100";

	public static abstract class Master implements BaseColumns
	{
		public static final String	TABLE_NAME			= "master";
		public static final String	COLUMN_NAME_NAME	= "name";
		public static final String	COLUMN_NAME_DUE		= "duedate";

		private static final String	COLUMN0_CREATE		= "_ID INTEGER PRIMARY KEY";
		private static final String	COLUMN1_CREATE		= COLUMN_NAME_NAME + TEXT_TYPE;
		private static final String	COLUMN2_CREATE		= COLUMN_NAME_DUE + INTEGER_TYPE;

		public static final String	CREATE_TABLE		= "CREATE TABLE " + TABLE_NAME + " ("
																+ COLUMN0_CREATE + SEPARATOR
																+ COLUMN1_CREATE + SEPARATOR
																+ COLUMN2_CREATE + ")";

		public static final String	DELETE_TABLE		= "DROP TABLE IF EXISTS " + TABLE_NAME;
		public static final String	GET_TABLE			= SQLiteQueryBuilder.buildQueryString(
																false, TABLE_NAME, null, null,
																null, null, null, ROW_LIMIT);

		public static final String getMaster(long id)
		{
			return SQLiteQueryBuilder.buildQueryString(false, TABLE_NAME, null, "_ID=" + id, null,
					null, null, ROW_LIMIT);
		}

	}

	public static abstract class Transactions implements BaseColumns
	{
		public static final String	TABLE_NAME			= "transaction";
		public static final String	COLLUMN_NAME_DATE	= "date";
		public static final String	COLLUMN_NAME_VALUE	= "value";

		private static final String	COLUMN0_CREATE		= "_ID INTEGER PRIMARY KEY";
		private static final String	COLUMN1_CREATE		= COLLUMN_NAME_DATE + INTEGER_TYPE;
		private static final String	COLUMN2_CREATE		= COLLUMN_NAME_VALUE + INTEGER_TYPE;

		public static final String	CREATE_TABLE		= "CREATE TABLE " + TABLE_NAME + " ("
																+ COLUMN0_CREATE + SEPARATOR
																+ COLUMN1_CREATE + SEPARATOR
																+ COLUMN2_CREATE + ")";

		public static final String	DELETE_TABLE		= "DROP TABLE IF EXISTS " + TABLE_NAME;
		public static final String	GET_TABLE			= SQLiteQueryBuilder.buildQueryString(
																false, TABLE_NAME, null, null,
																null, null, COLLUMN_NAME_DATE,
																ROW_LIMIT);

		public static final String getTransactionWithId(long[] id)
		{
			int size = id.length;
			String idInString = "(";
			for (int i = 0; i < size; i++)
			{
				idInString = idInString + id[i] + ",";
			}
			idInString = idInString.substring(1, idInString.length() - 1) + ")";
			return SQLiteQueryBuilder.buildQueryString(false, TABLE_NAME, null, "_ID IN "
					+ idInString, null, null, COLLUMN_NAME_DATE, ROW_LIMIT);
		}

		public static final String getSpesificTransaction(long id)
		{
			return SQLiteQueryBuilder.buildQueryString(false, TABLE_NAME, null, "_ID=" + id, null,
					null, null, ROW_LIMIT);
		}
	}

	public static abstract class MasterAndTransaction implements BaseColumns
	{
		public static final String	TABLE_NAME				= "transmaster";
		public static final String	COLLUMN_NAME_MASTERID	= "masterid";
		public static final String	COLLUMN_NAME_TRANSID	= "transactionid";

		public static final String	TYPE_MASTERID			= INTEGER_TYPE;
		public static final String	TYPE_TRANSACTIONID		= INTEGER_TYPE;

		private static final String	COLUMN0_CREATE			= "_ID INTEGER PRIMARY KEY";
		private static final String	COLUMN1_CREATE			= COLLUMN_NAME_MASTERID + INTEGER_TYPE;
		private static final String	COLUMN2_CREATE			= COLLUMN_NAME_TRANSID + INTEGER_TYPE;

		public static final String	CREATE_TABLE			= "CREATE TABLE " + TABLE_NAME + " ("
																	+ COLUMN0_CREATE + SEPARATOR
																	+ COLUMN1_CREATE + SEPARATOR
																	+ COLUMN2_CREATE + ")";

		public static final String	GET_TABLE				= SQLiteQueryBuilder.buildQueryString(
																	false, TABLE_NAME, null, null,
																	null, null, null, ROW_LIMIT);
		public static final String	DELETE_TABLE			= "DROP TABLE IF EXISTS " + TABLE_NAME;

		public static final String getTransactionWithMasterId(long id)
		{
			return SQLiteQueryBuilder.buildQueryString(false, TABLE_NAME,
					new String[] { COLLUMN_NAME_TRANSID }, COLLUMN_NAME_MASTERID + "=" + id, null,
					null, null, ROW_LIMIT);
		}

		public static final String deleteTransactionsWithMasterId(long id)
		{
			return "DELETE FROM " + TABLE_NAME + " WHERE " + COLLUMN_NAME_MASTERID + "=" + id;
		}
	}

	public DatabaseHelper(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(Master.CREATE_TABLE);
		db.execSQL(Transactions.CREATE_TABLE);
		db.execSQL(MasterAndTransaction.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// no plan to upgradeDB
	}

}
