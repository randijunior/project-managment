package com.springframework.projectmanagment.project;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springframework.projectmanagment.model.BaseEntity;

@Entity
public class Task extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "project_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Project project;
	
	@Column(name = "date_creation")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime date = LocalDateTime.now();
	
	private Status status = Status.PENDING;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
