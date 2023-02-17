package com.stonetek.managerproject.entities;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_developers")
public class Developer implements Serializable {

    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "developer_name", nullable = false)
    private String developerName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "workload", nullable = false)
    private Integer workload;

    
    @JoinTable(name = "tb_bond", 
    joinColumns = {@JoinColumn(name = "developer_id", referencedColumnName = "id") }, 
    inverseJoinColumns = {@JoinColumn(name = "project_id", referencedColumnName = "id") })
    @ManyToMany
    private List<Project> projectList;

}