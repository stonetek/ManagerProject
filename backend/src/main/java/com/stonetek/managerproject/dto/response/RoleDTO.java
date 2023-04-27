package com.stonetek.managerproject.dto.response;

import com.stonetek.managerproject.entities.Role;

import java.io.Serializable;
import java.util.Objects;

public class RoleDTO implements Serializable {

    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String authority;

    public RoleDTO() {}

    public RoleDTO(Long id, String authority) {
        this.id = id;
        this.authority = authority;

    }

    public RoleDTO(Role role) {
        id = role.getId();
        authority = role.getAuthority();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RoleDTO other = (RoleDTO) obj;
        return Objects.equals(id, other.id);
    }

}
