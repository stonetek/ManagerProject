package com.stonetek.managerproject.services;

import com.stonetek.managerproject.dto.mapper.ProjectMapper;
import com.stonetek.managerproject.dto.request.ProjectRequest;
import com.stonetek.managerproject.dto.response.ProjectResponse;
import com.stonetek.managerproject.entities.Project;
import com.stonetek.managerproject.exception.ProjectNotFoundException;
import com.stonetek.managerproject.repositories.ProjectRepository;
import com.stonetek.managerproject.util.ResourceUriUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<ProjectResponse> listar() {
        List<Project> projects = projectRepository.findAll();
        return ProjectMapper.converter(projects);
    }

    public ProjectResponse salvar(ProjectRequest request) {
        Project project = ProjectMapper.converter(request);
        project = projectRepository.save(project);
        ResourceUriUtil.addUriInResponseHeader(project.getId()); // Adiciona no header da resquição o recurso que foi
                                                                 // criado
        return ProjectMapper.converter(project);
    }

    public ProjectResponse buscarPorId(Integer idProject) {
        Optional<Project> project = projectRepository.findById(idProject);
        if (project.isEmpty()) {
            throw new ProjectNotFoundException(idProject);
        }
        return ProjectMapper.converter(project.get());
    }

    public ProjectResponse editar(Integer idProject, ProjectRequest request) {
        ProjectResponse projectEncontrado = buscarPorId(idProject);
        Project project = ProjectMapper.converter(projectEncontrado);
        ProjectMapper.copyToProperties(request, project);
        project = projectRepository.save(project);
        return ProjectMapper.converter(project);
    }

    public void excluir(Integer idProject) {
        try {
            projectRepository.deleteById(idProject);
        } catch (EmptyResultDataAccessException ex) {
            throw new ProjectNotFoundException(idProject);
        }
    }
}
