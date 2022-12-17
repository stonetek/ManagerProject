package com.stonetek.managerproject.dto.response;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectResponse implements Serializable {

    private static final long serialVersionUID = 1L;
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

}
