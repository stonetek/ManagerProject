package com.stonetek.managerproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stonetek.managerproject.entities.User;

public interface UserRepository extends JpaRepository<User, String>{ 
    User findByUsername(String username); 
}
