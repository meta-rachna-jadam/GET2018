package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.dao.query.SkillsQuery;
import com.metacube.training.mappers.SkillsMapper;
import com.metacube.training.model.Skills;

@Repository
public class SkillsDAOImplementation implements SkillsDAO {

    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SkillsDAOImplementation(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Skills getSkillsById(int id) {
		return jdbcTemplate.queryForObject(SkillsQuery.SQL_FIND_SKILLS, new Object[] { id }, 
			    new SkillsMapper());
	}

	@Override
	public List<Skills> getAllSkills() {
		return jdbcTemplate.query(SkillsQuery.SQL_GET_ALL, new SkillsMapper());
	}

	@Override
	public boolean deleteSkills(Skills skills) {
		//return jdbcTemplate.update(SkillsQuery.SQL_DELETE_SKILLS, skills.getId()) > 0;
		return false;
	}

	@Override
	public boolean updateSkills(Skills skills) {
		return jdbcTemplate.update(SkillsQuery.SQL_UPDATE_SKILLS, skills.getName(), skills.getId()) > 0;
	}

	@Override
	public boolean createSkills(Skills skills) {
		return jdbcTemplate.update(SkillsQuery.SQL_INSERT_SKILLS, skills.getName()) > 0;
	}
}
