package com.stonetek.managerproject.controllers;

import com.stonetek.managerproject.entities.User;
import com.stonetek.managerproject.login.LoginRequest;
import com.stonetek.managerproject.login.LoginResponse;
import com.stonetek.managerproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User salvar(@RequestBody User user) {
        return userService.salvar(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.logar(request.getEmail(), request.getSenha());
    }
    
}
