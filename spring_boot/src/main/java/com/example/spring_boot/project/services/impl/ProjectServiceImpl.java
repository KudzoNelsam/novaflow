package com.example.spring_boot.project.services.impl;

import com.example.spring_boot.project.dto.request.ProjectRequestDto;
import com.example.spring_boot.project.entity.Project;
import com.example.spring_boot.project.exceptions.ProjectAlreadyExist;
import com.example.spring_boot.project.mapper.ProjectMapper;
import com.example.spring_boot.project.repository.ProjectRepository;
import com.example.spring_boot.project.services.ProjectService;
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
        return repository.getByName(name);
    }

    @Override
    public Boolean isExistByName(String name) {
        return repository.existsByName(name);
    }
}
