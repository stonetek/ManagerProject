package com.stonetek.managerproject.repositories;

import com.stonetek.managerproject.dto.response.UserDTO;

public class UserInsertDTO extends UserDTO {
    private static final long serialVersionUID = 1l;

    private String senha;

    public UserInsertDTO() {
        super();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
