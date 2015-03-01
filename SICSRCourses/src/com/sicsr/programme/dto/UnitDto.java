package com.sicsr.programme.dto;

import java.util.Date;

import android.database.Cursor;

public class UnitDto {

	private Integer id;
	private String name;
	private Date created;
	private Date modified;
	private Integer status;

	public UnitDto(Cursor contentItemCursor) {
		if (!(contentItemCursor == null || contentItemCursor.isAfterLast())) {
			this.setId(contentItemCursor.getInt(contentItemCursor.getColumnIndex("id")));
			this.setName(contentItemCursor.getString(contentItemCursor.getColumnIndex("name")));
		}
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}



}
