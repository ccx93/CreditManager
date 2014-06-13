package com.ccx.creditmanager;

import android.provider.BaseColumns;

public class DatabaseContract
{
	public DatabaseContract() {};
	
	public static abstract class Masters implements BaseColumns
	{
		public static final String TABLE_NAME = "master";
		public static final String COLLUMN_NAME_ID = "id";
		public static final String COLLUMN_NAME_NAME = "name";

		public static final String TYPE_ID = "STRING";
		public static final String TYPE_NAME = "TEXT";
	}
	
	
	public static abstract class Transactions implements BaseColumns
	{
		public static final String TABLE_NAME = "transaction";
		public static final String COLLUMN_NAME_ID = "id";
		public static final String COLLUMN_NAME_VALUE = "value";
		public static final String COLLUMN_NAME_DATE = "date";
		
		public static final String TYPE_ID = "STRING";
		public static final String TYPE_VALUE = "LONG";
		public static final String TYPE_DATE = "DATE";
	}
	
	public static abstract class MasterLink implements BaseColumns
	{
		public static final String TABLE_NAME = "transmaster";
		public static final String COLLUMN_NAME_MASTERID = "masterid";
		public static final String COLLUMN_NAME_TRANSACTIONID = "transactionid";

		public static final String TYPE_MASTERID = "STRING";
		public static final String TYPE_TRANSACTIONID = "STRING";
	}
	
}
