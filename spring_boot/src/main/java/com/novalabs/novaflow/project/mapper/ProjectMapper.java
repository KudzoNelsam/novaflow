package com.novalabs.novaflow.project.mapper;

import com.novalabs.novaflow.project.dto.request.ProjectRequestDto;
import com.novalabs.novaflow.project.dto.response.ProjectResponseDto;
import com.novalabs.novaflow.project.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public ProjectResponseDto toDto(Project entity) {
        return new ProjectResponseDto(entity.getId(), entity.getName(), entity.getDescription());
    }

    public Project toEntity(ProjectRequestDto requestDto){
        return Project.builder()
                .name(requestDto.name())
                .description(requestDto.description())
                .build();
    }
}
