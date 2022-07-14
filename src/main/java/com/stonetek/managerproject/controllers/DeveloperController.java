package com.stonetek.managerproject.controllers;


import com.stonetek.managerproject.dto.DeveloperDTO;
import com.stonetek.managerproject.entities.Developer;
import com.stonetek.managerproject.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
