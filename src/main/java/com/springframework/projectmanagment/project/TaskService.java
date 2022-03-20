package com.springframework.projectmanagment.project;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskService {
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	public List<Task> findAll() {
		return this.taskRepository.findAll();
	}
	
	public Task createTask(Task task) {
		return this.taskRepository.save(task);
	}
	
}
