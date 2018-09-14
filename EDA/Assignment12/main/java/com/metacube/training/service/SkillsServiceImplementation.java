package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.Skills;
import com.metacube.training.repository.SkillsRepository;

/**
 * class provide services related to skills
 * @author Rachna Jadam
 *
 */

@Service
public class SkillsServiceImplementation implements SkillsService {

	@Autowired
	private SkillsRepository<Skills> skillsRepository;

	/**
	 * To get skills by id
	 */
	@Override
	public Skills getSkillsById(int id) {
		return skillsRepository.findOne(id);
	}

	/**
	 * To get skills list
	 */
	@Override
	public List<Skills> getAllSkills() {
		return skillsRepository.findAll();
	}

	/**
	 * To delete skills by id
	 */
	@Override
	public boolean deleteSkills(int id) {
		skillsRepository.delete(id);
		return true;
	}

	/**
	 * To update skills
	 */
	@Override
	public boolean updateSkills(Skills skills) {
		skillsRepository.saveAndFlush(skills);
		return true;
	}

	/**
	 * To create skills entry in database 
	 */
	@Override
	public boolean createSkills(Skills skills) {
		skillsRepository.save(skills);
		return true;
	}
}