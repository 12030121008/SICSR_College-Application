package com.sicsr.programme.entity;

import java.io.Serializable;

import android.content.ContentValues;

public abstract class BaseEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String created;
	private String modified;

	public BaseEntity() {

	}

	public BaseEntity(Long id, String created, String modified) {
		super();
		this.id = id;
		this.created = created;
		this.modified = modified;
	}

	public abstract ContentValues getContentValues();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public enum Column {

		ID("id"), CREATED("created"), MODIFIED("modified");

		private String column;

		private Column(String column) {
			this.column = column;
		}

		public String getValue() {
			return this.column;
		}
	}
}
