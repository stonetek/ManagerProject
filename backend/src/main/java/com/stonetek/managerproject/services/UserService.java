package com.stonetek.managerproject.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stonetek.managerproject.dto.mapper.ProjectMapper;
import com.stonetek.managerproject.dto.response.ProjectResponse;
import com.stonetek.managerproject.entities.Project;
import com.stonetek.managerproject.entities.User;
import com.stonetek.managerproject.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService  {

	private final UserRepository repository;
	
	PasswordEncoder passwordEncoder;
	
	public List<User> listar() {
        //List<Project> projects = projectRepository.findAllByOrderByClientNameAsc();
        return repository.findAll();
    }
	
	public Optional<User> buscarPorId(Long id) {
        //List<Project> projects = projectRepository.findAllByOrderByClientNameAsc();
        return repository.findById(id);
    }
	
	public Optional<User> buscarPorEmail(String email) {
        //List<Project> projects = projectRepository.findAllByOrderByClientNameAsc();
        return repository.findByEmail(email);
    }
	
	public User salvar(User user) {
		user.setId(null);
		
		if(buscarPorEmail(user.getEmail()).isPresent()) {
			throw new InputMismatchException("Já existe cadastro desse e-mail: " + user.getEmail());
		}
		
		//Gerando hash da senha
		String senha = passwordEncoder.encode(user.getSenha());
		
		user.setSenha(senha);
		return repository.save(user);
	}
	
	

	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException { var user = repository.findByEmail(username); if
	 * (user != null) { return (UserDetails) user; } else { throw new
	 * UsernameNotFoundException("Username " + username + " not found"); }
	 * 
	 * }
	 */
}