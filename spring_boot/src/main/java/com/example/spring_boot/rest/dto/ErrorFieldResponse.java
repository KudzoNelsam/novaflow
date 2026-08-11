package com.example.spring_boot.rest.dto;

import java.util.Map;

public record ErrorFieldResponse(
        int statusCode,
        Map<String, String> message
) {
}
