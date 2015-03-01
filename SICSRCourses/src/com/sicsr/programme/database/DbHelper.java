package com.sicsr.programme.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "sicsr";
	private static final Integer DATABASE_VERSION = 1;
	private Context context;

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//db.execSQL(DbScriptHelper.createUserTable());

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onCreate(db);
	}

	public Context getContext() {
		return context;
	}
}
