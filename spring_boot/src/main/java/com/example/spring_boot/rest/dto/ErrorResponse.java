package com.example.spring_boot.rest.dto;

public record ErrorResponse(
        int statusCode,
        String message
) {
}
