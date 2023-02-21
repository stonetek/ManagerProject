package com.stonetek.managerproject.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "perfil")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToMany
    @JoinTable(name = "usuario_perfil",
        joinColumns = { @JoinColumn(name = "perfil_id", referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "usuario_id", referencedColumnName = "id") }
    )
    private List<Usuario> usuarioList;

}
