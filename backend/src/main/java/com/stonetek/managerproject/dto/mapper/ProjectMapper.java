package com.stonetek.managerproject.dto.mapper;


import com.stonetek.managerproject.dto.request.ProjectRequest;
import com.stonetek.managerproject.dto.response.ProjectResponse;
import com.stonetek.managerproject.entities.Project;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class ProjectMapper {

private final static ModelMapper mapper = new ModelMapper();
    
	public static ProjectResponse converter(Project project) {
        return mapper.map(project, ProjectResponse.class);
    }
	
	public static Project converter(ProjectRequest request) {
        return mapper.map(request, Project.class);
    }
	
	public static Project converter(ProjectResponse response) {
        return mapper.map(response, Project.class);
    }
	
	public static List<ProjectResponse> converter(List<Project> projects) {
        return projects.stream().map(ProjectMapper::converter).collect(Collectors.toList());
    }
	
	public static void copyToProperties(ProjectRequest request, Project project) {
        mapper.map(request, project);
    }
}
