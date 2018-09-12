package com.metacube.training.model;

public class EmployeeSkills {

    private int id;
    private int employeeId;
    private int skillId;
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
