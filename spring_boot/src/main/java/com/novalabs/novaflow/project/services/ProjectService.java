package com.novalabs.novaflow.project.services;

import com.novalabs.novaflow.project.dto.request.ProjectRequestDto;
import com.novalabs.novaflow.project.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project create(ProjectRequestDto projectRequestDto);

    List<Project> getAll();

    Optional<Project> getByName(String name);

    boolean isExistByName(String name);
}
