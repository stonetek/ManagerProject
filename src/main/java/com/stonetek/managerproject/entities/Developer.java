package com.stonetek.managerproject.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "tb_developers")
public class Developer implements Serializable {

    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String developerName;
    private String email;

    private Date birthDate;
    private Double salary;
    private Integer workload;

    public Developer() {

    }

    public Developer(Long id, String developerName, String email, Date birthDate, Double salary, Integer workload) {
        super();
        this.id = id;
        this.developerName = developerName;
        this.email = email;
        this.birthDate = birthDate;
        this.salary = salary;
        this.workload = workload;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer)) return false;
        Developer developer = (Developer) o;
        return getId() == developer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}