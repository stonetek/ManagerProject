package com.stonetek.managerproject.repositories;

import com.stonetek.managerproject.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

}
