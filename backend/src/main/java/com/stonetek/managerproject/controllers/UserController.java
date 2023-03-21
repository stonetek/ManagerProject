package com.stonetek.managerproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stonetek.login.LoginRequest;
import com.stonetek.login.LoginResponse;
import com.stonetek.managerproject.entities.User;
import com.stonetek.managerproject.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;


@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> obterTodos() {
        return userService.listar();
    }

    @GetMapping("/{id}")
    public Optional<User> buscarPorId(@PathVariable("id") long id) {
        return userService.buscarPorId(null);
    }

    @PostMapping
    public User salvar(@RequestBody User user) {
        return userService.salvar(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.logar(request.getEmail(), request.getSenha());
    }
    
}
