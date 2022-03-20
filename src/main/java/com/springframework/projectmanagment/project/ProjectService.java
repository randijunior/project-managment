package com.springframework.projectmanagment.project;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectService {
	
	private final ProjectRepository projectRepository;
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public List<Project> findAll() {
		return this.projectRepository.findAll();
	}
	
	public Project create(Project project) {
		return this.projectRepository.save(project);
	}
	
	
}
