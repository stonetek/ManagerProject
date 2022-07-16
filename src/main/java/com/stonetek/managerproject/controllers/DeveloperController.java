package com.stonetek.managerproject.controllers;


import com.stonetek.managerproject.dto.DeveloperDTO;
import com.stonetek.managerproject.dto.ProjectDTO;
import com.stonetek.managerproject.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService service;

    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> findAll() {
        List<DeveloperDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<DeveloperDTO> insert(@RequestBody DeveloperDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
