package com.sicsr.programme.database;


public class DbScriptHelper {
	
	public static String createUserTable(){
		return "CREATE TABLE users (id INTEGER PRIMARY KEY  NOT NULL , name TEXT, surname TEXT, username TEXT, mobile_number TEXT, password TEXT, status INTEGER, created TEXT, modified TEXT);";
	}
 
}
