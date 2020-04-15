package com.FinalBugProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {
	@Id
	@Column
	private long Id;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		this.Id = id;
	}
	@Column(columnDefinition="text")
	private String Subject;
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	private String senderEmail;
}
