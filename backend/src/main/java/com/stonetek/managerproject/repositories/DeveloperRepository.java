package com.stonetek.managerproject.repositories;

import com.stonetek.managerproject.entities.Developer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
	List<Developer> findAllByOrderByDeveloperNameAsc();
	
}
