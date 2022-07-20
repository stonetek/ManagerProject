package com.stonetek.managerproject.dto.request;

import java.io.Serializable;
import java.util.Date;

public class DeveloperRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String developerName;
    private String email;
    private Date birthDate;
    private Double salary;
    private Integer workload;

    public DeveloperRequest(String developerName, String email, Date birthDate, Double salary, Integer workload) {
        this.developerName = developerName;
        this.email = email;
        this.birthDate = birthDate;
        this.salary = salary;
        this.workload = workload;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getWorkload() {
        return workload;
    }
}
