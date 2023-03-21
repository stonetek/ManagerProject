package com.stonetek.login;

import com.stonetek.managerproject.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    
    private String token;

    private User user;
}
