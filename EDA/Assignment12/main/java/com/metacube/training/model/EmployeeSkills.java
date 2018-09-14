package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class map with employeeSkills table of database
 * @author Rachna Jadam
 *
 */

@Entity
@Table(name = "employeeSkills")
public class EmployeeSkills {

	@Id
	@Column(name = "emp_skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
	@Column(name = "emp_code")
    private int employeeId;
	
	@Column(name = "skill_code")
    private int skillId;
    
    @Override
	public String toString() {
		return "Employee Skills [id=" + id + ", employeeId=" + employeeId + ", skillId="
				+ skillId + "]";
	}
	public int getId() {
		return id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	
}
