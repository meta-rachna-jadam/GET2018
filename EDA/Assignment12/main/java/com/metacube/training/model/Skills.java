package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "skills")
public class Skills {

	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "skill_name")
    private String name;
	
	@OneToOne(mappedBy = "employeeSkillsId")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private EmployeeSkills employeeSkills;
	
	@Override
	public String toString() {
		return "Skills [id=" + id + ", name=" + name + "]";
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
