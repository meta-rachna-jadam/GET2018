package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Project;

public class ProjectService implements AdminService<Project>{

	@Override
	public Project getFieldById(int id) {
		return null;
	}

	@Override
	public List<Project> getListOfField() {
		return null;
	}

	@Override
	public boolean deleteFieldById(int id) {
		return false;
	}

	@Override
	public boolean updateFieldById(Project project) {
		return false;
	}

	@Override
	public boolean createField(Project project) {
		return false;
	}

}
