package com.novalabs.novaflow.project.mapper;

import com.novalabs.novaflow.project.dto.request.ProjectRequest;
import com.novalabs.novaflow.project.dto.response.ProjectResponse;
import com.novalabs.novaflow.project.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectResponse toDto(Project entity) {
        return new ProjectResponse(entity.getId(), entity.getName(), entity.getDescription());
    }

    public Project toEntity(ProjectRequest requestDto){
        return Project.builder()
                .name(requestDto.name())
                .description(requestDto.description())
                .build();
    }
}
