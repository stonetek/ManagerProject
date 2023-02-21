package com.stonetek.managerproject.controllers;

//import com.stonetek.managerproject.entities.Developer;
//import com.stonetek.managerproject.entities.Project;
//import com.stonetek.managerproject.repositories.DeveloperRepository;
//import com.stonetek.managerproject.repositories.ProjectRepository;
//import com.stonetek.managerproject.entities.Project;
//import com.stonetek.managerproject.repositories.DeveloperRepository;
//import com.stonetek.managerproject.repositories.ProjectRepository;
import com.stonetek.managerproject.services.ProjectService;
import com.stonetek.managerproject.dto.request.ProjectRequest;
import com.stonetek.managerproject.dto.response.ProjectResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.Optional;

//import javax.persistence.EntityNotFoundException;
//import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/projects")
public class ProjectController {

    
	private final ProjectService projectService;
	
	
    @GetMapping
    public ResponseEntity<List<ProjectResponse>> listar() {
        return ResponseEntity.ok().body(projectService.listar());
    }

    @GetMapping(path = "/{idProject}")
    public ResponseEntity<ProjectResponse> buscarPorId(@PathVariable("projectId") Integer idProject) {
        ProjectResponse project = projectService.buscarPorId(idProject);
        return ResponseEntity.ok().body(project);
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> salvar(@Valid @RequestBody ProjectRequest request) {
        ProjectResponse project = projectService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }
    

    @PutMapping(path = "/{idProject}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<ProjectResponse> editar(@PathVariable("idProject") Integer idProject,
            @Valid @RequestBody ProjectRequest request) {
        ProjectResponse project = projectService.editar(idProject, request);
        return ResponseEntity.ok().body(project);
    }
    


    @DeleteMapping(path = "/{idProject}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("idProject") Integer idProject) {
        projectService.excluir(idProject);
    }
    
    
    
    /*@PostMapping(path ="/developers/{idDeveloper}/projects/{idProject}")
    	public ResponseEntity<Project> bondDev(@PathVariable(value = "idDeveloper") Integer idDeveloper, @RequestBody Project projectRequest) {
    		Project project = developerRepository.findById(idDeveloper).map(developer -> {
    			Integer idProject = projectRequest.getId();
    			if (idProject != 0) {
    				Project _project = projectRepository.findById(idProject)
    						.orElseThrow(()-> new EntityNotFoundException("Not found Tag with id = " + idProject));
    				developer.addProject(_project);
    				developerRepository.save(developer);
    				
    				return _project;
    			}
    				developer.addProject(projectRequest);
    				return projectRepository.save(projectRequest);
    		}).orElseThrow(() -> new EntityNotFoundException("Not found Tutorial with id = " + idDeveloper));

    		return new ResponseEntity<>(project, HttpStatus.CREATED);
    
    		}*/
}