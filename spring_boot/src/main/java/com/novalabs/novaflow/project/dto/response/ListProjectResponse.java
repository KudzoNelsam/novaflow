package com.novalabs.novaflow.project.dto.response;

import java.util.List;

public record ListProjectResponse(
        List<ProjectResponse> projects
) {
}
