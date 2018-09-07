package com.metacube.training.service;

import java.util.List;

import com.metacube.training.dao.SkillsDao;
import com.metacube.training.model.Skills;

public class SkillsService implements AdminService<Skills> {

	@Override
	public Skills getFieldById(int id) {
		return null;
	}

	@Override
	public List<Skills> getListOfField() {
		return null;
	}

	@Override
	public boolean deleteFieldById(int id) {
		return false;
	}

	@Override
	public boolean updateFieldById(Skills skills) {
		return false;
	}

	@Override
	public boolean createField(Skills skills) {
		return new SkillsDao().createField(skills);
	}

	
}
