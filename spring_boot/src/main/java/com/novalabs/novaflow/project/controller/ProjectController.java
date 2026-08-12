package com.novalabs.novaflow.project.controller;

import com.novalabs.novaflow.project.dto.request.ProjectRequest;
import com.novalabs.novaflow.project.dto.response.ListProjectResponse;
import com.novalabs.novaflow.project.dto.response.ProjectResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("projects")
public interface ProjectController {

    @PostMapping
    ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody ProjectRequest requestDto);

    @GetMapping
    ResponseEntity<ListProjectResponse> getAllProject();
}
