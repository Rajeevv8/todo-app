package com.app.todo.dto;

import java.util.Date;


public class ModelDTO {
	private Integer entryNumber;
	private Date completionDate;
	private String title;
	private Boolean completionStatus;
	private String dateString;

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public int getEntryNumber() {
		return entryNumber;
	}

	public void setEntryNumber(Integer entryNumber) {
		this.entryNumber = entryNumber;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date creationDate) {
		this.completionDate = creationDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(Boolean completionStatus) {
		this.completionStatus = completionStatus;
	}

}
