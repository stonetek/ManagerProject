package com.stonetek.managerproject.repositories;

import com.stonetek.managerproject.entities.Project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findAllByOrderByProjectNameAsc();
}
