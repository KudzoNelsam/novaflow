package com.novalabs.novaflow.project.controller.impl;

import com.novalabs.novaflow.project.controller.ProjectController;
import com.novalabs.novaflow.project.dto.request.ProjectRequestDto;
import com.novalabs.novaflow.project.dto.response.ListProjectResponseDto;
import com.novalabs.novaflow.project.dto.response.ProjectResponseDto;
import com.novalabs.novaflow.project.entity.Project;
import com.novalabs.novaflow.project.mapper.ProjectMapper;
import com.novalabs.novaflow.project.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectControllerImpl implements ProjectController {
    private final ProjectService service;
    private final ProjectMapper mapper;


    @Override
    public ResponseEntity<ProjectResponseDto> createProject(ProjectRequestDto requestDto) {
        Project project = service.create(requestDto);
        ProjectResponseDto created = mapper.toDto(project);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ListProjectResponseDto> getAllProject() {
        ListProjectResponseDto responses = new ListProjectResponseDto(service.getAll().stream().map((mapper::toDto)).toList());
        return ResponseEntity.ok(responses);
    }
}
