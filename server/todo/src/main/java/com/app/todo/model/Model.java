package com.app.todo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class Model {
	
	public Model() {
	}
	
	public Model(Date creationDate, String title, Boolean completionStatus) {
		super();
		this.creationDate = creationDate;
		this.title = title;
		this.completionStatus = completionStatus;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "entryNumber")
	private Integer entryNumber;
	
	@Column(name = "creationDate")
	private Date creationDate;

	@Column(name = "title")
	private String title;
	
	@Column(name = "completionStatus")
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
