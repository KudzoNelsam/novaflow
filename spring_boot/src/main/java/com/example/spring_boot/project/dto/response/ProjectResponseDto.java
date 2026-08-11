package com.example.spring_boot.project.dto.response;

public record ProjectResponseDto(
        Long id,
        String name,
        String description
) {
}
