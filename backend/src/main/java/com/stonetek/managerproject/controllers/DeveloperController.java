package com.stonetek.managerproject.controllers;


import com.stonetek.managerproject.dto.mapper.DeveloperMapper;
import com.stonetek.managerproject.dto.request.DeveloperRequest;
import com.stonetek.managerproject.dto.response.DeveloperResponse;
import com.stonetek.managerproject.entities.Developer;
import com.stonetek.managerproject.services.DeveloperService;
import com.stonetek.managerproject.util.ResourceUriUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService service;

    @GetMapping
    public ResponseEntity<List<DeveloperResponse>> findAll() {
        List<DeveloperResponse> developerList = service.findAll();
        return ResponseEntity.ok().body(developerList);
    }

    @GetMapping("/{idDeveloper}")
    public ResponseEntity<DeveloperResponse> findById(@PathVariable Long idDeveloper) {
        Developer developer = service.findById(idDeveloper);
        return ResponseEntity.ok().body(DeveloperMapper.to(developer));
    }

    @PostMapping
    public ResponseEntity<DeveloperResponse> create(@RequestBody DeveloperRequest request) {
        Developer developer = DeveloperMapper.to(request);
        developer = service.save(developer);
        ResourceUriUtil.addUriInResponseHeader(developer.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(DeveloperMapper.to(developer));
    }

    @PutMapping("/{idDeveloper}")
    public ResponseEntity<DeveloperResponse> update(@PathVariable Long idDeveloper, @RequestBody DeveloperRequest request) {
        Developer developer = service.findById(idDeveloper);
        DeveloperMapper.copyToProperties(request, developer);
        developer = service.save(developer);
        return ResponseEntity.ok().body(DeveloperMapper.to(developer));
    }

    @DeleteMapping("/{idDeveloper}")
    public void deleteById(@PathVariable Long idDeveloper) {
        service.delete(idDeveloper);
    }

}
