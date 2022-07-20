package com.stonetek.managerproject.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "tb_projects")
public class Project implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String clientName;
    private LocalDate date;
    private String deadline;
    private Double budget;

//    @ManyToMany
//    @JoinTable(name = "tb_bond",
//    joinColumns = @JoinColumn(name = "project_id"),
//    inverseJoinColumns = @JoinColumn(name = "developer_id"))
//    private Set<Developer> developers = new HashSet<>();

    @ManyToMany(mappedBy = "projectList")
    private List<Developer> developerList;

    public Project() {

    }

    public Project(Long id, String projectName, String clientName, LocalDate date, String deadline, Double budget) {
        super();
        this.id = id;
        this.projectName = projectName;
        this.clientName = clientName;
        this.date = date;
        this.deadline = deadline;
        this.budget = budget;
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

    public List<Developer> getDeveloperList() {
        return developerList;
    }

    public void setDeveloperList(List<Developer> developerList) {
        this.developerList = developerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return getId().equals(project.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
