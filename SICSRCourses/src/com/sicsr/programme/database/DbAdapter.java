package com.sicsr.programme.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class DbAdapter {

	private Context context;
	private DbHelper dbHelper;
	private SQLiteDatabase database;

	public DbAdapter(Context context) {
		this.context = context;
	}

	public DbAdapter open() {
		this.dbHelper = new DbHelper(context);
		AssetDatabaseOpenHelper assetDatabaseOpenHelper = new AssetDatabaseOpenHelper(context);
		assetDatabaseOpenHelper.openDatabase(dbHelper,database);	
		database = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		if (this.dbHelper != null) {
			this.dbHelper.close();
			this.database.close();
		}
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public DbHelper getDbHelper() {
		return dbHelper;
	}

	public void setDbHelper(DbHelper dbHelper) {
		this.dbHelper = dbHelper;
	}

	public SQLiteDatabase getDatabase() {
		return database;
	}

	public void setDatabase(SQLiteDatabase database) {
		this.database = database;
	}
}
