package com.stonetek.managerproject.exception;

public class ProjectNotFoundException extends EntityNotFoundException {
    private static final long serialVersionUID = 1L;

    public ProjectNotFoundException(String message) {
        super(message);
    }

    public ProjectNotFoundException(Integer id) {
        this(String.format("Não existe registro de projeto com id: %d", id));
    }
}
