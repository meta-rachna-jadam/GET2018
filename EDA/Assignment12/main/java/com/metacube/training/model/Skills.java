package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class map with skills table of database
 * @author Rachna Jadam
 *
 */

@Entity
@Table(name = "skills")
public class Skills {

	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "skill_name")
    private String name;
	
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
