package com.stonetek.managerproject.exception;

public class UserNotFoundException extends EntityNotFoundException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Long id) {
        this(String.format("Não existe registro de projeto com id: %d", id));
    }
    
}
