package com.sicsr.programme.database.dao;

import com.sicsr.programme.activity.BaseActivity;
import com.sicsr.programme.database.DbAdapter;

public class BaseDao {

	private BaseActivity initActivity;

	public BaseDao(BaseActivity initActivity) {
		this.initActivity = initActivity;
	}

	public BaseActivity getInitActivity() {
		return initActivity;
	}

	public void setInitActivity(BaseActivity initActivity) {
		this.initActivity = initActivity;
	}

	public DbAdapter getDbAdapter() {
		return initActivity.getBaseFrameworkApplication().getDbAdapter();
	}
}
