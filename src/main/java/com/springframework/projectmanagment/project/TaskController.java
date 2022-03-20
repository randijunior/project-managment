package com.springframework.projectmanagment.project;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {
	private final TaskService taskService;
	private final ProjectRepository projectService;
	
	public TaskController(TaskService taskService, ProjectRepository projectRepository) {
		this.taskService = taskService;
		this.projectService = projectRepository;
	}
	@GetMapping
	public ResponseEntity<List<Task>> findAll() {
		return ResponseEntity.ok(this.taskService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody @Valid Task task) {
		Optional<Project> optionalProject = projectService.findById(task.getProject().getId());
		if(!optionalProject.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		task.setProject(optionalProject.get());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.taskService.createTask(task));
	}
}
