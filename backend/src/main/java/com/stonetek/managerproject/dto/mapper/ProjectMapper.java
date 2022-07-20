package com.stonetek.managerproject.dto.mapper;

import com.stonetek.managerproject.dto.request.ProjectRequest;
import com.stonetek.managerproject.dto.response.ProjectResponse;
import com.stonetek.managerproject.entities.Project;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static Project to(ProjectRequest request) {
        Project project = new Project();
        project.setProjectName(request.getProjectName());
        project.setClientName(request.getClientName());
        project.setDate(request.getDate());
        project.setDeadline(request.getDeadline());
        project.setBudget(request.getBudget());
        return project;
    }

    public static ProjectResponse to(Project project) {
        ProjectResponse response = new ProjectResponse();
        response.setId(project.getId());
        response.setProjectName(project.getProjectName());
        response.setClientName(project.getClientName());
        response.setDate(project.getDate());
        response.setDeadline(project.getDeadline());
        response.setBudget(project.getBudget());
        return response;
    }

    public static List<ProjectResponse> toList(List<Project> projectList) {
        return projectList.stream()
                .map(project -> to(project))
                .collect(Collectors.toList());
    }

}
