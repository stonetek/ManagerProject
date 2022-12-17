package com.stonetek.managerproject.repositories;

import com.stonetek.managerproject.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
