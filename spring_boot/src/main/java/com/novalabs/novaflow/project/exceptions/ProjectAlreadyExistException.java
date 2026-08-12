package com.novalabs.novaflow.project.exceptions;

public class ProjectAlreadyExistException extends RuntimeException {
    public ProjectAlreadyExistException(String name) {
        super(String.format("Le projet avec le nom %s existe deja", name));
    }
}
