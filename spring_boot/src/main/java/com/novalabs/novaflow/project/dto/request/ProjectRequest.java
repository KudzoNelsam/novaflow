package com.novalabs.novaflow.project.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
        @NotBlank(message = "Le nom du projet est obligatoire")
        String name,
        @NotBlank(message = "La description du projet est obligatoire")
        String description
) {
}
