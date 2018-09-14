package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.EmployeeSkills;
public interface EmployeeSkillsRepository<P> extends JpaRepository<EmployeeSkills, Integer> {

}
