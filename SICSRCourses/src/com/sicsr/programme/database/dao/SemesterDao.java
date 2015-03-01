package com.sicsr.programme.database.dao;

import com.sicsr.programme.activity.BaseActivity;
import com.sicsr.programme.database.DbOperationResponse;
import com.sicsr.programme.database.DbOperations;
import com.sicsr.programme.entity.SemesterEntity;

 

public abstract class SemesterDao extends BaseDao implements DbOperations<SemesterEntity>{

	public SemesterDao(BaseActivity initActivity) {
		super(initActivity);
	}
	
	public abstract DbOperationResponse findSemesters(int branchId);

}
