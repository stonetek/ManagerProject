package com.stonetek.managerproject.controllers;

import com.stonetek.managerproject.dto.request.ProjectRequest;
import com.stonetek.managerproject.dto.response.ProjectResponse;
import com.stonetek.managerproject.services.ProjectService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> listar() {
        return ResponseEntity.ok().body(projectService.listar());
    }

    @GetMapping("/{idProject}")
    public ResponseEntity<ProjectResponse> buscarPorId(@PathVariable Integer idProject) {
        ProjectResponse project = projectService.buscarPorId(idProject);
        return ResponseEntity.ok().body(project);
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> salvar(@Valid @RequestBody ProjectRequest request) {
        ProjectResponse project = projectService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @PutMapping("/{idProject}")
    public ResponseEntity<ProjectResponse> editar(@PathVariable Integer idProject,
            @Valid @RequestBody ProjectRequest request) {
        ProjectResponse project = projectService.editar(idProject, request);
        return ResponseEntity.ok().body(project);
    }

    @DeleteMapping("/{idProject}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer idProject) {
        projectService.excluir(idProject);
    }

}
