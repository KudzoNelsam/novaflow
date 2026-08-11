package com.novalabs.novaflow.project.services.impl;

import com.novalabs.novaflow.project.dto.request.ProjectRequestDto;
import com.novalabs.novaflow.project.entity.Project;
import com.novalabs.novaflow.project.exceptions.ProjectAlreadyExist;
import com.novalabs.novaflow.project.mapper.ProjectMapper;
import com.novalabs.novaflow.project.repository.ProjectRepository;
import com.novalabs.novaflow.project.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;
    private final ProjectMapper mapper;


    @Override
    public Project create(ProjectRequestDto projectRequestDto) {
        Project project = mapper.toEntity(projectRequestDto);

        if (isExistByName(project.getName())) {
            throw new ProjectAlreadyExist(project.getName());
        }
        return repository.save(project);
    }

    @Override
    public List<Project> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Project> getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public boolean isExistByName(String name) {
        return repository.existsByName(name);
    }
}
