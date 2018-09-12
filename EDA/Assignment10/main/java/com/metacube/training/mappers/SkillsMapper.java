package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Skills;

public class SkillsMapper implements RowMapper<Skills> {

	public Skills mapRow(ResultSet resultSet, int i) throws SQLException {

		Skills skills = new Skills();
		skills.setId(resultSet.getInt("skill_id"));
		skills.setName(resultSet.getString("skill_name"));
		return skills;
	}
}