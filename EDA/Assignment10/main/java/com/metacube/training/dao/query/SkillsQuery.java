package com.metacube.training.dao.query;

public interface SkillsQuery {

	String SQL_FIND_SKILLS = "select skill_id, skill_name from skills where skill_id = ?";
    
	//String SQL_DELETE_PROJECT = "update skills set enabled = false where skill_id = ?";
    
	String SQL_UPDATE_SKILLS = "update skills set skill_name = ? where skill_id = ?";
    
	String SQL_GET_ALL = "select skill_id, skill_name from skills";
    
	String SQL_INSERT_SKILLS = "insert into skills (skill_name) values (?)";
}
