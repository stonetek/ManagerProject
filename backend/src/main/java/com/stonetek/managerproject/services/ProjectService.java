package com.stonetek.managerproject.services;

import com.stonetek.managerproject.entities.Project;
import com.stonetek.managerproject.repositories.DeveloperRepository;
import com.stonetek.managerproject.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Autowired
    private DeveloperRepository developerRepository;


    public List<Project> findAll() {
        return repository.findAllByOrderByClientNameAsc();
    }

//    public ProjectDTO insert(ProjectDTO dto) {
//        Project project = new Project(null, dto.getProjectName(), dto.getClientName(), dto.getDate(), dto.getDeadline(), dto.getBudget());
//        project = repository.save(project);
//        return new ProjectDTO(project);
//    }

    public Project save(Project project) {
        return repository.save(project);
    }

}
