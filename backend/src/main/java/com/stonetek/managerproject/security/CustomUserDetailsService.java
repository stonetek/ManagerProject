package com.stonetek.managerproject.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

//import com.stonetek.managerproject.entities.User;
//import com.stonetek.managerproject.repositories.UserRepository;
import com.stonetek.managerproject.services.UserService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UserService userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) {
		/*
		 * User user = getUser(() -> userService.buscarPorEmail(email)); return user;
		 */
		return userService.buscarPorEmail(email).get();
	}
	
	public UserDetails buscarUserPorId(Long id) {
		return userService.buscarPorId(id).get();
	}
	
	/*
	 * private User getUser(Supplier<Optional<User>> supplier) { return
	 * supplier.get().orElseThrow(()-> new
	 * UsernameNotFoundException("Usuário Não encontrado!")); }
	 */
	
}
