package com.example.spring_boot.project.services;

import com.example.spring_boot.project.dto.request.ProjectRequestDto;
import com.example.spring_boot.project.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project create(ProjectRequestDto projectRequestDto);

    List<Project> getAll();

    Optional<Project> getByName(String name);

    Boolean isExistByName(String name);
}
