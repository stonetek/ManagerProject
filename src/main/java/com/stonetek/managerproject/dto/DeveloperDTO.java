package com.stonetek.managerproject.dto;

import com.stonetek.managerproject.entities.Developer;

import java.io.Serializable;
import java.util.Date;

public class DeveloperDTO implements Serializable {

    private static final long serialVersionUID = 1l;
    private long id;
    private String developerName;
    private String email;
    private Date birthDate;
    private Double salary;
    private Integer workload;

    public DeveloperDTO(long id, String developerName, String email, Date birthDate, Double salary, Integer workload) {
        this.id = id;
        this.developerName = developerName;
        this.email = email;
        this.birthDate = birthDate;
        this.salary = salary;
        this.workload = workload;
    }

    public DeveloperDTO(Developer entity) {
        id = entity.getId();
        developerName = entity.getDeveloperName();
        email = entity.getEmail();
        birthDate = entity.getBirthDate();
        salary = entity.getSalary();
        workload = entity.getWorkload();
    }

    public DeveloperDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }
}
