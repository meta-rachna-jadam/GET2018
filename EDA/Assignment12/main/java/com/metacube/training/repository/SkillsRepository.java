package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.training.model.Skills;

public interface SkillsRepository<P> extends JpaRepository<Skills, Integer> {

}
