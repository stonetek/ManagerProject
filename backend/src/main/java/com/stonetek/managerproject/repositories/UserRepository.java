package com.stonetek.managerproject.repositories;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stonetek.managerproject.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);


}
