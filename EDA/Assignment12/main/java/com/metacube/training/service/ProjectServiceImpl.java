package com.metacube.training.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

/**
 * class provide services related to project
 * @author Rachna Jadam
 *
 */

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
    private ProjectRepository<Project> projectRepository;

	/**
	 * To get project list
	 */
	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}
	
	/**
	 * To update project
	 */
	@Override
	public boolean updateProject(Project project) {
		project.setLogo("D:\\HTML Pages\\Capture.PNG");
		projectRepository.saveAndFlush(project);
		return true;
	}

	/**
	 * To create project entry in database
	 */
	@Override
	public boolean createProject(Project project) {
		project.setLogo("D:\\HTML Pages\\Capture.PNG");
		projectRepository.save(project);
		return true;
	}

	/**
	 * To get project by id
	 */
	@Override
	public Project getProjectById(int id) {
		return projectRepository.findOne(id);
	}

	/**
	 * To delete project by id
	 */
	@Override
	public boolean deleteProject(int id) {
		projectRepository.delete(id);
		return true;
	}
}
