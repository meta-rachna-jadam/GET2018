package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employeeSkills")
public class EmployeeSkills {

	@Id
	@Column(name = "emp_skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    /*@OneToOne
    @JoinColumn(name="emp_code")*/
	/*@Column(name = "emp_code")
    private int employeeId;*/
	
	@Column(name = "emp_code")
	@GenericGenerator(name = "gen", strategy = "foreign", 
			parameters = { @Parameter(name = "property", value = "employeeSkillsId") })
    private long employeeId;
    
    /*@ManyToMany
    @JoinColumn(name="skill_code")*/
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
