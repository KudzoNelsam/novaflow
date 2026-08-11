package com.novalabs.novaflow.project.controller;

import com.novalabs.novaflow.project.dto.request.ProjectRequestDto;
import com.novalabs.novaflow.project.dto.response.ListProjectResponseDto;
import com.novalabs.novaflow.project.dto.response.ProjectResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("projects")
public interface ProjectController {

    @PostMapping
    ResponseEntity<ProjectResponseDto> createProject(@Valid @RequestBody ProjectRequestDto requestDto);

    @GetMapping
    ResponseEntity<ListProjectResponseDto> getAllProject();
}
