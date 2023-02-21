package com.stonetek.managerproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stonetek.managerproject.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
