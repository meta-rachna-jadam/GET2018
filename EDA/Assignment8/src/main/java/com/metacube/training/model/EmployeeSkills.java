package com.metacube.training.model;

public class EmployeeSkills {

    private int id;
    private int employeeId;
    private int skillId;
	public EmployeeSkills(int id, int employeeId, int skillId) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.skillId = skillId;
	}
	public EmployeeSkills(int employeeId, int skillId) {
		super();
		this.employeeId = employeeId;
		this.skillId = skillId;
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

    
}
