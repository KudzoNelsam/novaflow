package com.example.spring_boot.project.controller.impl;

import com.example.spring_boot.project.dto.request.ProjectRequestDto;
import com.example.spring_boot.project.dto.response.ListProjectResponseDto;
import com.example.spring_boot.project.dto.response.ProjectResponseDto;
import com.example.spring_boot.project.entity.Project;
import com.example.spring_boot.project.mapper.ProjectMapper;
import com.example.spring_boot.project.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class projectControllerImpl implements ProjectController {
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
