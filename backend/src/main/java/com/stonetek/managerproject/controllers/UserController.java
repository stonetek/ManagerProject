package com.stonetek.managerproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stonetek.managerproject.dto.response.UserResponse;
import com.stonetek.managerproject.entities.User;
import com.stonetek.managerproject.login.LoginRequest;
import com.stonetek.managerproject.login.LoginResponse;
import com.stonetek.managerproject.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;


@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usuarios")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> obterTodos() {
        return ResponseEntity.ok().body(userService.listar());
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<UserResponse> buscarPorId(@PathVariable Long idUser) {
        UserResponse user = userService.buscarPorId(idUser);
        return ResponseEntity.ok().body(user);
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
