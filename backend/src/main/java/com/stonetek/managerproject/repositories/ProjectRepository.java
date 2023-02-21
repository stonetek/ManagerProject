package com.stonetek.managerproject.repositories;

import com.stonetek.managerproject.entities.Project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	List<Project> findAllByOrderByClientNameAsc();

}
