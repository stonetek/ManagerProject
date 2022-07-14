package com.stonetek.managerproject.services;

import com.stonetek.managerproject.entities.Project;
import com.stonetek.managerproject.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository repository;

    @Autowired
    public List<Project> findProjects() {
        return repository.findAll();
    }

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }
}
