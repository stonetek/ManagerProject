package com.stonetek.managerproject.services;


import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
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

import com.stonetek.managerproject.dto.mapper.ProjectMapper;
import com.stonetek.managerproject.dto.mapper.UserMapper;
import com.stonetek.managerproject.dto.request.UserRequest;
import com.stonetek.managerproject.dto.response.ProjectResponse;
import com.stonetek.managerproject.dto.response.UserResponse;
import com.stonetek.managerproject.entities.Project;
import com.stonetek.managerproject.entities.User;
import com.stonetek.managerproject.exception.UserNotFoundException;
import com.stonetek.managerproject.login.LoginResponse;
import com.stonetek.managerproject.repositories.UserRepository;
import com.stonetek.managerproject.security.JWTService;
import com.stonetek.managerproject.util.ResourceUriUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService  {

	private static final String headerPrefix = "Bearer ";

	private final UserRepository userRepository;

	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTService jwtService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<UserResponse> listar() {
        List<User> users = userRepository.findAllByOrderByEmailAsc();
		return UserMapper.converter(users); 
    }

	public UserResponse salvar(UserRequest request) {
        User user = UserMapper.converter(request);
        user = userRepository.save(user);
        ResourceUriUtil.addUriInResponseHeader(user.getId()); // Adiciona no header da resquição o recurso que foi
                                                                 // criado
        return UserMapper.converter(user);
    }

	public UserResponse buscarPorId(Long idUser) {
        Optional<User> user = userRepository.findById(idUser);
        if (user.isEmpty()) {
            throw new UserNotFoundException(idUser);
        }
        return UserMapper.converter(user.get());
    }

	public UserResponse editar(Long idUser, UserRequest request) {
        UserResponse userEncontrado = buscarPorId(idUser);
        User user = UserMapper.converter(userEncontrado);
        UserMapper.copyToProperties(request, user);
        user = userRepository.save(user);
        return UserMapper.converter(user);
    }
	
	public void excluir(Long idUser) {
        try {
            userRepository.deleteById(idUser);
        } catch (EmptyResultDataAccessException ex) {
            throw new UserNotFoundException(idUser);
        }
    }

	public Optional<User> buscarPorEmail(String email) {
        return userRepository.findByEmail(email);
    }
	
	public User salvar(User user) {
		user.setId(null);
		
		if(buscarPorEmail(user.getEmail()).isPresent()) {
			throw new InputMismatchException("Já existe cadastro desse e-mail: " + user.getEmail());
		}
		
		//Gerando hash da senha
		String senha = passwordEncoder.encode(user.getSenha());
		
		user.setSenha(senha);
		return userRepository.save(user);
	}

	public LoginResponse logar(String email, String senha) {
		//Autenticação ocorre aqui.	
		Authentication auth = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(email, senha, Collections.emptyList()));
			SecurityContextHolder.getContext().setAuthentication(auth);

			String token = headerPrefix + jwtService.gerarToken(auth);

			User user = userRepository.findByEmail(email).get();

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
