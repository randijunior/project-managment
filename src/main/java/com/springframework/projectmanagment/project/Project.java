package com.springframework.projectmanagment.project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.springframework.projectmanagment.model.BaseEntity;



@Entity
public class Project extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	
	private String title;
	private String description;
	
	@OneToMany(mappedBy = "project",
	        cascade = CascadeType.ALL)
	private List<Task> tasks = new ArrayList<>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
	

}
