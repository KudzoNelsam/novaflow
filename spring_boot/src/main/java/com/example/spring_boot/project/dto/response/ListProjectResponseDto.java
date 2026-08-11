package com.example.spring_boot.project.dto.response;

import java.util.List;

public record ListProjectResponseDto(
        List<ProjectResponseDto> projects
) {
}
