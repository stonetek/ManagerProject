package com.stonetek.managerproject.controllers;

import com.stonetek.managerproject.entities.User;
import com.stonetek.managerproject.login.LoginRequest;
import com.stonetek.managerproject.login.LoginResponse;
import com.stonetek.managerproject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User salvar(@RequestBody User user) {
        return userService.salvar(user);
    }

    @PostMapping("/{id}")
    public Optional<User> login(@PathVariable("id")Long id) {
        return userService.buscarPorId(id);
    }

    @PostMapping
    public User adcionar (@RequestBody User user) {
        return userService.salvar(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.logar(request.getEmail(), request.getSenha());
    }
    
}
