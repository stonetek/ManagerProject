package com.stonetek.managerproject.controllers;

import com.stonetek.managerproject.dto.request.DeveloperRequest;
import com.stonetek.managerproject.dto.response.DeveloperResponse;
import com.stonetek.managerproject.services.DeveloperService;
//import com.stonetek.managerproject.dto.response.ProjectResponse;
//import com.stonetek.managerproject.entities.Developer;
//import com.stonetek.managerproject.entities.Project;
//import com.stonetek.managerproject.services.ProjectService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping
    public ResponseEntity<List<DeveloperResponse>> listar() {
        return ResponseEntity.ok().body(developerService.listar());
    }

    @GetMapping(path = "/{idDeveloper}")
    public ResponseEntity<DeveloperResponse> buscarPorId(@PathVariable Integer idDeveloper) {
        DeveloperResponse developer = developerService.buscarPorId(idDeveloper);
        return ResponseEntity.ok().body(developer);
    }

    @PostMapping
    public ResponseEntity<DeveloperResponse> salvar(@Valid @RequestBody DeveloperRequest request) {
        DeveloperResponse developer = developerService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(developer);
    }

    @PutMapping(path = "/{idDeveloper}")
    public ResponseEntity<DeveloperResponse> editar(@PathVariable Integer idDeveloper,
            @Valid @RequestBody DeveloperRequest request) {
        DeveloperResponse developer = developerService.editar(idDeveloper, request);
        return ResponseEntity.ok().body(developer);
    }

    @DeleteMapping(path = "/{idDeveloper}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer idDeveloper) {
        developerService.excluir(idDeveloper);
    }

}
