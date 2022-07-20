package com.stonetek.managerproject.repositories;

import com.stonetek.managerproject.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    List<Developer> findAllByOrderByDeveloperNameAsc();
}
