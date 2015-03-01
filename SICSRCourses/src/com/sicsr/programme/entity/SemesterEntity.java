package com.sicsr.programme.entity;

import android.content.ContentValues;

public class SemesterEntity extends BaseEntity {

	
	private static final long serialVersionUID = 1L;

	private String name;
	private Integer status;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	@Override
	public ContentValues getContentValues() {
		ContentValues classContentValues = new ContentValues();
		classContentValues.put(BaseEntity.Column.ID.getValue(), getId());
		classContentValues.put(BaseEntity.Column.CREATED.getValue(), getCreated());
		classContentValues.put(BaseEntity.Column.MODIFIED.getValue(), getModified());
		classContentValues.put(BranchEntity.Column.NAME.getValue(), getName());
		classContentValues.put(BranchEntity.Column.STATUS.getValue(), getStatus());
		return classContentValues;
	}


	public enum Column {

		NAME("name"),STATUS("status");

		private String column;

		private Column(String column) {
			this.column = column;
		}

		public String getValue() {
			return this.column;
		}
	}

	public enum Table {

		SEMESTERS("semesters");

		private String table;

		private Table(String table) {
			this.table = table;
		}

		public String getValue() {
			return this.table;
		}
	}

}
