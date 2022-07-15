package com.stonetek.managerproject.dto;

import com.stonetek.managerproject.entities.Project;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectDTO implements Serializable {

    private static final long serialVersionUID = 1l;
    private Long id;
    private String projectName;
    private String clientName;
    private LocalDate date;
    private String deadline;
    private Double budget;

    private List<DeveloperDTO> developers = new ArrayList<>();

    public ProjectDTO() {
    }

    public ProjectDTO(Long id, String projectName, String clientName, LocalDate date, String deadline, Double budget) {
        this.id = id;
        this.projectName = projectName;
        this.clientName = clientName;
        this.date = date;
        this.deadline = deadline;
        this.budget = budget;
    }

    public ProjectDTO(Project entity) {
        id = entity.getId();
        projectName = entity.getProjectName();
        clientName = entity.getClientName();
        date = entity.getDate();
        deadline = entity.getDeadline();
        budget = entity.getBudget();
        developers = entity.getDevelopers().stream().map(x -> new DeveloperDTO(x)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public List<DeveloperDTO> getDevelopers() {
        return developers;
    }

}
