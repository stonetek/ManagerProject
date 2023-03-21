package com.stonetek.managerproject.services;


import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stonetek.login.LoginResponse;
import com.stonetek.managerproject.dto.mapper.ProjectMapper;
import com.stonetek.managerproject.dto.response.ProjectResponse;
import com.stonetek.managerproject.entities.Project;
import com.stonetek.managerproject.entities.User;
import com.stonetek.managerproject.repositories.UserRepository;
import com.stonetek.managerproject.security.JWTService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService  {

	private static final String headerPrefix = "Bearer ";

	private final UserRepository repository;

	private AuthenticationManager authenticationManager;
	
	private JWTService jwtService;
	
	private PasswordEncoder passwordEncoder;
	
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

	public LoginResponse logar(String email, String senha) {
		//Autenticação ocorre aqui.	
		Authentication auth = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(email, senha, Collections.emptyList()));
			SecurityContextHolder.getContext().setAuthentication(auth);

			String token = headerPrefix + jwtService.gerarToken(auth);

			User user = repository.findByEmail(email).get();

			return new LoginResponse(token, user);


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
