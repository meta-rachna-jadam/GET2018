package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Skills;

public interface SkillsDAO {

	Skills getSkillsById(int id);

	List<Skills> getAllSkills();

	boolean deleteSkills(Skills skills);

	boolean updateSkills(Skills skills);

	boolean createSkills(Skills skills);
}
