package com.metacube.training.dao.query;

public interface SkillsQuery {

	String CREATE_SKILLS = "INSERT INTO skills (skill_name) VALUES (?)";

    String UPDATE_SKILLS_BY_ID = "UPDATE skills SET skill_name = ? WHERE skill_id = ?";

    //String DELETE_SKILLS_BY_ID = "UPDATE skills SET enabled = ? WHERE skill_id = ?";

    String GET_ALL_SKILLS = "SELECT skill_id, skill_name FROM skills";
    
    String GET_ALL_SKILLS_NAME = "SELECT skill_name FROM skills";

    String GET_SKILLS_BY_ID = "SELECT skill_id, skill_name FROM skills WHERE skill_id = ?";
}
