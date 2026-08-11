package com.novalabs.novaflow.rest.dto;

public record ErrorResponse(
        int statusCode,
        String message
) {
}
