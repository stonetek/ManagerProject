package com.stonetek.managerproject.securingweb;

import com.stonetek.managerproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;



@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) {

           return userService.buscarPorEmail(email).get();
    }

    public UserDetails buscaId(Long id) {

        return userService.buscarPorId(id).get();
    }

}
