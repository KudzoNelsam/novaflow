package com.novalabs.novaflow;

import com.novalabs.novaflow.project.dto.request.ProjectRequest;
import com.novalabs.novaflow.project.entity.Project;
import com.novalabs.novaflow.project.repository.ProjectRepository;
import com.novalabs.novaflow.project.services.ProjectService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void shouldCreateProject() {

    }

}
