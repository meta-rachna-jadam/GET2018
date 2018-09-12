package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.query.ProjectQuery;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Project getProjectById(int id) {
		return jdbcTemplate.queryForObject(ProjectQuery.SQL_FIND_PROJECT, new Object[] { id }, 
		    new ProjectMapper());
	}

	public List<Project> getAllProjects() {
		return jdbcTemplate.query(ProjectQuery.SQL_GET_ALL, new ProjectMapper());
	}

	public boolean deleteProject(Project project) {
		return jdbcTemplate.update(ProjectQuery.SQL_DELETE_PROJECT, project.getId()) > 0;
	}

	public boolean updateProject(Project project) {
		return jdbcTemplate.update(ProjectQuery.SQL_UPDATE_PROJECT, 
		    project.getDescription(), project.getStartDate(), project.getEndDate(), project.getId()) > 0;
	}

	public boolean createProject(Project project) {
		return jdbcTemplate.update(ProjectQuery.SQL_INSERT_PROJECT, 
		    project.getDescription(), project.getStartDate(), project.getEndDate()) > 0;
	}
}