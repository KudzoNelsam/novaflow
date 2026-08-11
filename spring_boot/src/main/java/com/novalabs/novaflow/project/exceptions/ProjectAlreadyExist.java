package com.novalabs.novaflow.project.exceptions;

public class ProjectAlreadyExist extends RuntimeException {
    public ProjectAlreadyExist(String name) {
        super(String.format("Le projet avec le nom %s existe deja", name));
    }
}
