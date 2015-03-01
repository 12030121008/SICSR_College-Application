package com.sicsr.programme.database.dao.impl;

import android.database.Cursor;

import com.sicsr.programme.activity.BaseActivity;
import com.sicsr.programme.database.DbOperationResponse;
import com.sicsr.programme.database.dao.UnitDao;
import com.sicsr.programme.entity.UnitEntity;

public class UnitDaoImpl extends UnitDao {

	public UnitDaoImpl(BaseActivity initActivity) {
		super(initActivity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DbOperationResponse add(UnitEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbOperationResponse remove(Long entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbOperationResponse update(Long entityId, UnitEntity updatedEntity) {
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
	public DbOperationResponse findUnits(int subjectId) {
		DbOperationResponse dbResponse = new DbOperationResponse();

		try {

			StringBuilder sqlBuilder = new StringBuilder();

			sqlBuilder.append("SELECT * ");
			sqlBuilder.append("FROM " + UnitEntity.Table.UNITS.getValue() + " ");
			sqlBuilder.append(" WHERE subjectid = " +subjectId );

			Cursor cursor = getDbAdapter().getDatabase().rawQuery(sqlBuilder.toString(), null);

			dbResponse.setFetchedData(cursor);

			if (dbResponse.getFetchedData() != null && dbResponse.getFetchedData().getCount() > 0) {
				dbResponse.getMessages().add("UNITS retrieved");
				dbResponse.setStatus(true);
			} else {
				dbResponse.getErrors().add("No UNIT items found in the database");
				dbResponse.setStatus(false);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dbResponse;
	}

	 
 




}
