package com.sicsr.programme.database.dao;

import com.sicsr.programme.activity.BaseActivity;
import com.sicsr.programme.database.DbOperationResponse;
import com.sicsr.programme.database.DbOperations;
import com.sicsr.programme.entity.SemesterEntity;

 

public abstract class SubjectDao extends BaseDao implements DbOperations<SemesterEntity>{

	public SubjectDao(BaseActivity initActivity) {
		super(initActivity);
	}
	
	public abstract DbOperationResponse findSubjects(int semesterId);

}
