package com.stonetek.managerproject.dto.request;

import java.io.Serializable;
import java.time.LocalDate;

public class ProjectRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String projectName;
    private String clientName;
    private LocalDate date;
    private String deadline;
    private Double budget;

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
}
