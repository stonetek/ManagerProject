package com.stonetek.managerproject.login;

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
