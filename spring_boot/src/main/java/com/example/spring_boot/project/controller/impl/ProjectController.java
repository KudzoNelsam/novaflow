package com.example.spring_boot.project.controller.impl;

import com.example.spring_boot.project.dto.request.ProjectRequestDto;
import com.example.spring_boot.project.dto.response.ListProjectResponseDto;
import com.example.spring_boot.project.dto.response.ProjectResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("project")
public interface ProjectController {

    @PostMapping
    ResponseEntity<ProjectResponseDto> createProject(@Valid @RequestBody ProjectRequestDto requestDto);

    @GetMapping
    ResponseEntity<ListProjectResponseDto> getAllProject();
}
