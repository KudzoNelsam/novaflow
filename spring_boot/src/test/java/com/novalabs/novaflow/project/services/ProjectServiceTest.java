package com.novalabs.novaflow.project.services;

import com.novalabs.novaflow.project.dto.request.ProjectRequest;
import com.novalabs.novaflow.project.entity.Project;
import com.novalabs.novaflow.project.mapper.ProjectMapper;
import com.novalabs.novaflow.project.repository.ProjectRepository;
import com.novalabs.novaflow.project.services.impl.ProjectServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository repository;

    @Mock
    private ProjectMapper mapper;

    @InjectMocks
    private ProjectServiceImpl service;

    @Test
    void create() {
        // given
        ProjectRequest request = new ProjectRequest("NovaFlow", "Backend Spring Boot");

        Project entityToSave = new Project();
        entityToSave.setName("NovaFlow");
        entityToSave.setDescription("Backend Spring Boot");

        Project saved = new Project();
        saved.setName("NovaFlow");
        saved.setDescription("Backend Spring Boot");

        when(mapper.toEntity(request)).thenReturn(entityToSave);
        when(repository.save(entityToSave)).thenReturn(saved);

        // when
        Project result = service.create(request);

        // then
        assertThat(result.getName()).isEqualTo("NovaFlow");
        assertThat(result.getDescription()).isEqualTo("Backend Spring Boot");
    }

    @Test
    void getAll() {
        // given
        Project p1 = new Project();
        p1.setName("NovaFlow");
        p1.setDescription("Description1");

        Project p2 = new Project();
        p2.setName("NovaStream");
        p2.setDescription("Description2");


        when(repository.findAll()).thenReturn(List.of(p1, p2));

        // when
        List<Project> result = service.getAll();

        // then
        assertThat(result).hasSize(2);
        assertThat(result).extracting(Project::getName)
                .containsExactly("NovaFlow", "NovaStream");
    }

    @Test
    void findByName() {
        // given
        Project project = new Project();
        project.setName("NovaFlow");
        project.setDescription("Backend Spring Boot");

        when(repository.findByName("NovaFlow")).thenReturn(Optional.of(project));

        // when
        Project result = service.findByName("NovaFlow").get();

        // then
        assertThat(result.getName()).isEqualTo("NovaFlow");
        assertThat(result.getDescription()).isEqualTo("Backend Spring Boot");


    }

    @Test
    void isExistByName() {
        // given
        when(repository.existsByName("NovaFlow")).thenReturn(true);

        // when
        boolean result = service.isExistByName("NovaFlow");

        // then
        assertThat(result).isTrue();
    }

    @Test
    void findByName_shouldReturnEmptyWhenNotFound() {
        // given
        when(repository.findByName("Inconnu")).thenReturn(Optional.empty());

        // when
        Optional<Project> result = service.findByName("Inconnu");

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void isExistByName_shouldReturnFalseWhenNotFound() {
        // given
        when(repository.existsByName("Inconnu")).thenReturn(false);

        // when
        boolean result = service.isExistByName("Inconnu");

        // then
        assertThat(result).isFalse();
    }
}