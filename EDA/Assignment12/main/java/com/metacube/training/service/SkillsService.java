package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skills;

public interface SkillsService {
	
	Skills getSkillsById(int id);

	List<Skills> getAllSkills();

	boolean deleteSkills(int id);

	boolean updateSkills(Skills skills);

	boolean createSkills(Skills skills);


}
