package com.sicsr.programme.database.dao;

import com.sicsr.programme.activity.BaseActivity;
import com.sicsr.programme.database.DbOperationResponse;
import com.sicsr.programme.database.DbOperations;
import com.sicsr.programme.entity.UnitEntity;

 

public abstract class UnitDao extends BaseDao implements DbOperations<UnitEntity>{

	public UnitDao(BaseActivity initActivity) {
		super(initActivity);
	}
	
	public abstract DbOperationResponse findUnits(int subjectId);

}
