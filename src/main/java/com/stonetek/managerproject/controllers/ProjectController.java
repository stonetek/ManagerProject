package com.stonetek.managerproject.controllers;


import com.stonetek.managerproject.dto.ProjectDTO;
import com.stonetek.managerproject.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> findAll() {
        List<ProjectDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> insert(@RequestBody ProjectDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
