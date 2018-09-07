package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Project;

public class ProjectDao implements AdminDao<Project> {

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
