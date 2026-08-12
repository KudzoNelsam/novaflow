package com.novalabs.novaflow.project.services;

import com.novalabs.novaflow.project.dto.request.ProjectRequest;
import com.novalabs.novaflow.project.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project create(ProjectRequest projectRequest);

    List<Project> getAll();

    Optional<Project> findByName(String name);

    boolean isExistByName(String name);
}
