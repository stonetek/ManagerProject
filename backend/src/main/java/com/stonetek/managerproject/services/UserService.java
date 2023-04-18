package com.stonetek.managerproject.services;

import com.stonetek.managerproject.entities.User;
import com.stonetek.managerproject.exception.UserNotFoundException;
import com.stonetek.managerproject.login.LoginResponse;
import com.stonetek.managerproject.repositories.UserRepository;
import com.stonetek.managerproject.securingweb.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    private static final String headerPrefix = "Bearer ";

	@Autowired
    private UserRepository userRepository;

	@Autowired
    private AuthenticationManager authenticationManager;

	@Autowired
	private JWTService jwtService;

	@Autowired
    private PasswordEncoder passwordEncoder;

    public void excluir(Long idUser) {
        try {
            userRepository.deleteById(idUser);
        } catch (EmptyResultDataAccessException ex) {
            throw new UserNotFoundException(idUser);
        }
    }

	public List<User> obterTodos() {
		return userRepository.findAll();
	}

    public Optional<User> buscarPorEmail(String email) {
        return userRepository.buscarPorEmail(email);
    }

    public Optional<User> buscarPorId(Long id) { return userRepository.buscarPorId(id);}
	
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

			User user = userRepository.buscarPorEmail(email).get();

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