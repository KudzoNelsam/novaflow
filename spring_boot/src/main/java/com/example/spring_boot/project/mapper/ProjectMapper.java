package com.example.spring_boot.project.mapper;

import com.example.spring_boot.project.dto.request.ProjectRequestDto;
import com.example.spring_boot.project.dto.response.ProjectResponseDto;
import com.example.spring_boot.project.entity.Project;
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
