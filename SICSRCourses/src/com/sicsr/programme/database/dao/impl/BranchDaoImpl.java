package com.sicsr.programme.database.dao.impl;

import android.database.Cursor;

import com.sicsr.programme.activity.BaseActivity;
import com.sicsr.programme.database.DbOperationResponse;
import com.sicsr.programme.database.dao.BranchDao;
import com.sicsr.programme.entity.BranchEntity;

public class BranchDaoImpl extends BranchDao {

	public BranchDaoImpl(BaseActivity initActivity) {
		super(initActivity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DbOperationResponse add(BranchEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbOperationResponse remove(Long entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbOperationResponse update(Long entityId, BranchEntity updatedEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbOperationResponse exists(Long entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbOperationResponse findMaxId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbOperationResponse findById(Long entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbOperationResponse findBranches() {
		DbOperationResponse dbResponse = new DbOperationResponse();

		try {

			StringBuilder sqlBuilder = new StringBuilder();

			sqlBuilder.append("SELECT * ");
			sqlBuilder.append("FROM " + BranchEntity.Table.BRANCHES.getValue() + " ");
 
			Cursor cursor = getDbAdapter().getDatabase().rawQuery(sqlBuilder.toString(), null);
		 
			dbResponse.setFetchedData(cursor);

			if (dbResponse.getFetchedData() != null && dbResponse.getFetchedData().getCount() > 0) {
				dbResponse.getMessages().add("Branches retrieved");
				dbResponse.setStatus(true);
			} else {
				dbResponse.getErrors().add("No Branch items found in the database");
				dbResponse.setStatus(false);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dbResponse;
	}

}
