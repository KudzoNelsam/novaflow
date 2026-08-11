package com.novalabs.novaflow.rest.dto;

import java.util.Map;

public record ErrorFieldResponse(
        int statusCode,
        Map<String, String> message
) {
}
