package com.ccx.creditmanager;

import android.provider.BaseColumns;

public class DatabaseContract
{
	public DatabaseContract()
	{
	};

	public static final String	DATABASE_NAME		= "CreditMaster";
	public static final int		DATABASE_VERSION	= 1;

	private static final String	TEXT_TYPE			= " TEXT";
	private static final String	INTEGER_TYPE		= " INTEGER";
	private static final String	SEPARATOR			= ",";

	public static abstract class TransactionMaster implements BaseColumns
	{
		public static final String	TABLE_NAME			= "master";
		public static final String	COLUMN_NAME_NAME	= "name";

		public static final String	TYPE_NAME			= TEXT_TYPE;

		//formatteroff
		public static final String	CREATE_TABLE		= 
				"CREATE TABLE " + TABLE_NAME + " (" + 
				_ID + "INTEGER PRIMARY KEY," 
				+ COLUMN_NAME_NAME + TYPE_NAME + ")";
		//formatteron

		public static final String	DELETE_TABLE		= "DROP TABLE IF EXISTS " + TABLE_NAME;

	}

	public static abstract class Transactions implements BaseColumns
	{
		public static final String	TABLE_NAME			= "transaction";
		public static final String	COLLUMN_NAME_VALUE	= "value";
		public static final String	COLLUMN_NAME_DATE	= "date";

		public static final String	TYPE_VALUE			= INTEGER_TYPE;
		public static final String	TYPE_DATE			= INTEGER_TYPE;
		
		//formatteroff
		public static final String	CREATE_TABLE		= 
				"CREATE TABLE " + TABLE_NAME + " (" + 
				_ID + "INTEGER PRIMARY KEY," +
				COLLUMN_NAME_VALUE + TYPE_VALUE + SEPARATOR +
				COLLUMN_NAME_DATE + TYPE_DATE + ")";
		//formatteron

		public static final String	DELETE_TABLE		= "DROP TABLE IF EXISTS " + TABLE_NAME;
	}

	public static abstract class MasterAndTransaction implements BaseColumns
	{
		public static final String	TABLE_NAME					= "transmaster";
		public static final String	COLLUMN_NAME_MASTERID		= "masterid";
		public static final String	COLLUMN_NAME_TRANSACTIONID	= "transactionid";

		public static final String	TYPE_MASTERID				= INTEGER_TYPE;
		public static final String	TYPE_TRANSACTIONID			= INTEGER_TYPE;

		//formatteroff
		public static final String	CREATE_TABLE		= 
				"CREATE TABLE " + TABLE_NAME + " (" + 
				_ID + "INTEGER PRIMARY KEY," +
				COLLUMN_NAME_MASTERID + TYPE_MASTERID + SEPARATOR +
				COLLUMN_NAME_TRANSACTIONID + TYPE_TRANSACTIONID + ")";
		//formatteron

		public static final String	DELETE_TABLE				= "DROP TABLE IF EXISTS " + TABLE_NAME;
	}

}
