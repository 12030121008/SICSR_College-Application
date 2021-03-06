package com.sicsr.programme.database;

// "nice-to-have" class for verbose responses from the database

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;


public class DbOperationResponse {

	public static final boolean DB_RESPONSE_STATUS_SUCCESS = true;
	public static final boolean DB_RESPONSE_STATUS_FAILURE = false;

	private Boolean status;
	private Long lastInsertedId;
	private Integer rowsAffected;
	private Long maxId;
	private Integer userId;
	private Cursor fetchedData;
	private Integer previousId;
	private List<String> errors = new ArrayList<String>();
	private List<String> messages = new ArrayList<String>();

	public DbOperationResponse() {

	}

	public DbOperationResponse(Boolean status, Long lastInsertedId, Integer rowsAffected, Long maxId, Cursor fetchedData, List<String> errors, List<String> messages) {
		super();
		this.status = status;
		this.lastInsertedId = lastInsertedId;
		this.rowsAffected = rowsAffected;
		this.maxId = maxId;
		this.fetchedData = fetchedData;
		this.errors = errors;
		this.messages = messages;
	}

	public String getErrorString() {
		StringBuilder errorString = new StringBuilder();

		for (String error : this.errors) {
			errorString.append(error).append("\n");
		}

		return errorString.toString();
	}

	public String getMessageString() {
		StringBuilder messageString = new StringBuilder();

		for (String message : this.messages) {
			messageString.append(message).append("\n");
		}

		return messageString.toString();
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getLastInsertedId() {
		return lastInsertedId;
	}

	public void setLastInsertedId(Long lastInsertedId) {
		this.lastInsertedId = lastInsertedId;
	}

	public Integer getRowsAffected() {
		return rowsAffected;
	}

	public void setRowsAffected(Integer rowsAffected) {
		this.rowsAffected = rowsAffected;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public Cursor getFetchedData() {
		return fetchedData;
	}

	public void setFetchedData(Cursor fetchedData) {
		this.fetchedData = fetchedData;
	}

	public Long getMaxId() {
		return maxId;
	}

	public void setMaxId(Long maxId) {
		this.maxId = maxId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPreviousId() {
		return previousId;
	}

	public void setPreviousId(Integer previousId) {
		this.previousId = previousId;
	}
	

}
