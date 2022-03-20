package com.springframework.projectmanagment.project;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	private final ProjectService projectService;
	
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping
	public ResponseEntity<List<Project>> findAll() {
		return ResponseEntity.ok(this.projectService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Project> createProject(@RequestBody 
			Project project) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.projectService.create(project));
	}
	
}
