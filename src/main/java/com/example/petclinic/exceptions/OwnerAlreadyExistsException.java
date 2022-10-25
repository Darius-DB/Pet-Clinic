package com.example.petclinic.exceptions;

public class OwnerAlreadyExistsException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public OwnerAlreadyExistsException(String msg) {
        super(msg);
    }
}
