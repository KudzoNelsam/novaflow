package com.novalabs.novaflow.project.controller.impl;

import com.novalabs.novaflow.project.controller.ProjectController;
import com.novalabs.novaflow.project.dto.request.ProjectRequest;
import com.novalabs.novaflow.project.dto.response.ListProjectResponse;
import com.novalabs.novaflow.project.dto.response.ProjectResponse;
import com.novalabs.novaflow.project.entity.Project;
import com.novalabs.novaflow.project.mapper.ProjectMapper;
import com.novalabs.novaflow.project.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class ProjectControllerImpl implements ProjectController {
    private final ProjectService service;
    private final ProjectMapper mapper;


    @Override
    public ResponseEntity<ProjectResponse> createProject(ProjectRequest requestDto) {
        Project project = service.create(requestDto);
        ProjectResponse created = mapper.toDto(project);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ListProjectResponse> getAllProject() {
        ListProjectResponse responses = new ListProjectResponse(service.getAll().stream().map((mapper::toDto)).toList());
        return ResponseEntity.ok(responses);
    }
}
