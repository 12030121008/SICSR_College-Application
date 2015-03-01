package com.sicsr.programme.database.dao.impl;

import android.database.Cursor;

import com.sicsr.programme.activity.BaseActivity;
import com.sicsr.programme.database.DbOperationResponse;
import com.sicsr.programme.database.dao.SemesterDao;
import com.sicsr.programme.entity.SemesterEntity;

public class SemesterDaoImpl extends SemesterDao {

	public SemesterDaoImpl(BaseActivity initActivity) {
		super(initActivity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DbOperationResponse add(SemesterEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbOperationResponse remove(Long entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DbOperationResponse update(Long entityId,
			SemesterEntity updatedEntity) {
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
	public DbOperationResponse findSemesters(int branchId) {
		DbOperationResponse dbResponse = new DbOperationResponse();

		try {

			StringBuilder sqlBuilder = new StringBuilder();
			// SELECT s.id,s.branchid,s.name,s.status,s.created,s.modified FROM semesters s left join branches b on b.id = s.branchid
			/*sqlBuilder.append("SELECT s.id,s.branchid,s.name,s.status, ");
			sqlBuilder.append("s.created,s.modified ");
			sqlBuilder.append("FROM " + SemesterEntity.Table.SEMESTERS.getValue() + " s ");
			sqlBuilder.append("left join branches b on b.id = s.branchid ");*/
			
			
			sqlBuilder.append("SELECT * ");
			sqlBuilder.append("FROM " + SemesterEntity.Table.SEMESTERS.getValue() + " ");
			sqlBuilder.append(" WHERE branchid = " +branchId );

			Cursor cursor = getDbAdapter().getDatabase().rawQuery(sqlBuilder.toString(), null);

			dbResponse.setFetchedData(cursor);

			if (dbResponse.getFetchedData() != null && dbResponse.getFetchedData().getCount() > 0) {
				dbResponse.getMessages().add("SEMESTERS retrieved");
				dbResponse.setStatus(true);
			} else {
				dbResponse.getErrors().add("No SEMESTER items found in the database");
				dbResponse.setStatus(false);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dbResponse;
	}



}
