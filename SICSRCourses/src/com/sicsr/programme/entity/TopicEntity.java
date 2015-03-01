package com.sicsr.programme.entity;

import android.content.ContentValues;

import com.sicsr.programme.dto.TopicDto;

public class TopicEntity extends BaseEntity {

	
	private static final long serialVersionUID = 1L;

	private String name;
	private Integer status;
	private Integer completed;
	private Integer bookmark;

	
	public TopicEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public TopicEntity(TopicDto topicDto) {
		this.setId(topicDto.getId().longValue());
		this.setCompleted(topicDto.getCompleted());
		this.setBookmark(topicDto.getBookmarked());
		this.setName(topicDto.getName());
	}
	
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
		//classContentValues.put(BaseEntity.Column.ID.getValue(), getId());
/*		classContentValues.put(BaseEntity.Column.CREATED.getValue(), getCreated());
		classContentValues.put(BaseEntity.Column.MODIFIED.getValue(), getModified());
		classContentValues.put(TopicEntity.Column.NAME.getValue(), getName());
		classContentValues.put(TopicEntity.Column.STATUS.getValue(), getStatus());*/
		classContentValues.put(TopicEntity.Column.COMPLETED.getValue(), getCompleted());
		classContentValues.put(TopicEntity.Column.BOOKMARK.getValue(), getBookmark());
		return classContentValues;
	}


	public enum Column {

		NAME("name"),STATUS("status"),COMPLETED("completed"),BOOKMARK("bookmark");

		private String column;

		private Column(String column) {
			this.column = column;
		}

		public String getValue() {
			return this.column;
		}
	}

	public enum Table {

		TOPICS("topics");

		private String table;

		private Table(String table) {
			this.table = table;
		}

		public String getValue() {
			return this.table;
		}
	}

	public Integer getCompleted() {
		return completed;
	}

	public void setCompleted(Integer completed) {
		this.completed = completed;
	}

	public Integer getBookmark() {
		return bookmark;
	}

	public void setBookmark(Integer bookmark) {
		this.bookmark = bookmark;
	}
}
