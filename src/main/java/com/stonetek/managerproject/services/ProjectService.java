package com.stonetek.managerproject.services;

import com.stonetek.managerproject.dto.ProjectDTO;
import com.stonetek.managerproject.entities.Project;
import com.stonetek.managerproject.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Transactional
    public List<ProjectDTO> findAll() {
        List<Project> list = repository.findAll();
        return list.stream().map(x -> new ProjectDTO(x)).collect(Collectors.toList());
    }
}
