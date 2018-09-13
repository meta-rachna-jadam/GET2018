package com.metacube.training.dao.query;

public interface SkillsQuery {

	String SQL_FIND_SKILLS = "from Skills where skill_id = :id";
    
	String SQL_UPDATE_SKILLS = "update Skills set skill_name = :skill_name where skill_id = :id";
    
	String SQL_GET_ALL = "from Skills";
}
