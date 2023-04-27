package com.stonetek.managerproject.repositories;

import com.stonetek.managerproject.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
