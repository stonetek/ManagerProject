package com.stonetek.managerproject.controllers;


import com.stonetek.managerproject.dto.mapper.ProjectMapper;
import com.stonetek.managerproject.dto.request.ProjectRequest;
import com.stonetek.managerproject.dto.response.ProjectResponse;
import com.stonetek.managerproject.entities.Project;
import com.stonetek.managerproject.services.ProjectService;
import com.stonetek.managerproject.util.ResourceUriUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

//    @GetMapping
//    public ResponseEntity<List<ProjectDTO>> findAll() {
//        List<ProjectDTO> list = service.findAll();
//        return ResponseEntity.ok().body(list);
//    }
//
//    @PostMapping
//    public ResponseEntity<ProjectDTO> insert(@RequestBody ProjectDTO dto) {
//        dto = service.insert(dto);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
//                buildAndExpand(dto.getId()).toUri();
//        return ResponseEntity.created(uri).body(dto);
//    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> findAll(Pageable pageable) {
        List<Project> projectList = service.findAll(pageable);
        return ResponseEntity.ok().body(ProjectMapper.toList(projectList));
    }


    @PostMapping
    public ResponseEntity<ProjectResponse> create(@RequestBody ProjectRequest request) {
        Project project = ProjectMapper.to(request);
        project = service.save(project);
        ResourceUriUtil.addUriInResponseHeader(project.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(ProjectMapper.to(project));
    }

}
