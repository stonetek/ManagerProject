package com.stonetek.managerproject.repositories;


import com.stonetek.managerproject.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    List<Project> findAllByOrderByClientNameAsc();
}
