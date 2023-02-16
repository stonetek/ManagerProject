package com.stonetek.managerproject.entities;

import javax.persistence.*;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_projects")
public class Project implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "deadline", nullable = false)
    private String deadline;

    @Column(name = "budget", nullable = false)
    private Double budget;

    @ManyToMany(mappedBy = "projectList")
    private List<Developer> developerList;

}
