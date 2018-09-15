package com.metacube.training.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_code", insertable = false, updatable = false)
    private Employee employee;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_code", insertable = false, updatable = false)
    private Skills skills;
    
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
