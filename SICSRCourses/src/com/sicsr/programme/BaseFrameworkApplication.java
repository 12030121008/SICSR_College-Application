package com.sicsr.programme;

import android.app.Application;

import com.sicsr.programme.database.DbAdapter;


public class BaseFrameworkApplication extends Application {

 	private DbAdapter dbAdapter;
 
	@Override
	public void onCreate() {
		super.onCreate();
		initDb();
	}

	public void initDb() {
		this.dbAdapter = new DbAdapter(this).open();
	}

	public DbAdapter getDbAdapter() {
		return dbAdapter;
	}

	public void setDbAdapter(DbAdapter dbAdapter) {
		this.dbAdapter = dbAdapter;
	} 
}
