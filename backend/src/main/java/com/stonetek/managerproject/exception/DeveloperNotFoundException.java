package com.stonetek.managerproject.exception;

public class DeveloperNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public DeveloperNotFoundException(String message) {
        super(message);
    }

    public DeveloperNotFoundException(Integer id) {
        this(String.format("Não existe registro de desenvolvedor com id: %d", id));
    }

}