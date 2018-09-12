package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.SkillsDAO;
import com.metacube.training.model.Skills;

@Service
public class SkillsServiceImplementation implements SkillsService {

	@Autowired
	private SkillsDAO skillsDAO;

	@Override
	public Skills getSkillsById(int id) {
		return skillsDAO.getSkillsById(id);
	}

	@Override
	public List<Skills> getAllSkills() {
		return skillsDAO.getAllSkills();
	}

	@Override
	public boolean deleteSkills(int id) {
		Skills skills = skillsDAO.getSkillsById(id);
		return skillsDAO.deleteSkills(skills);
	}

	@Override
	public boolean updateSkills(Skills skills) {
		return skillsDAO.updateSkills(skills);
	}

	@Override
	public boolean createSkills(Skills skills) {
		return skillsDAO.createSkills(skills);
	}
}