package com.novalabs.novaflow.project.services;

import com.novalabs.novaflow.project.dto.request.ProjectRequest;
import com.novalabs.novaflow.project.entity.Project;
import com.novalabs.novaflow.project.exceptions.ProjectAlreadyExistException;
import com.novalabs.novaflow.project.mapper.ProjectMapper;
import com.novalabs.novaflow.project.repository.ProjectRepository;
import com.novalabs.novaflow.project.services.impl.ProjectServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void create_shouldThrowWhenNameAlreadyExists() {
        // given
        ProjectRequest request = new ProjectRequest("NovaFlow", "Backend Spring Boot");

        Project mappedProject = Project.builder()
                .name("NovaFlow")
                .description("Backend Spring Boot")
                .build();

        // il faut stuber le mapper AUSSI, même dans ce scénario,
        // car le service semble l'appeler avant (ou pendant) le contrôle de doublon
        when(mapper.toEntity(request)).thenReturn(mappedProject);
        when(repository.existsByName("NovaFlow")).thenReturn(true);

        // when / then
        assertThatThrownBy(() -> service.create(request))
                .isInstanceOf(ProjectAlreadyExistException.class);

        verify(repository, never()).save(any());
    }

    @Test
    void create() {
        // given
        ProjectRequest request = new ProjectRequest("NovaFlow", "Backend Spring Boot");

        Project entityToSave = Project.builder()
                .name("NovaFlow")
                .description("Backend Spring Boot")
                .build();

        Project saved = Project.builder()
                .name("NovaFlow")
                .description("Backend Spring Boot")
                .build();

        when(repository.existsByName("NovaFlow")).thenReturn(false);
        when(mapper.toEntity(request)).thenReturn(entityToSave);
        when(repository.save(entityToSave)).thenReturn(saved);

        // when
        Project result = service.create(request);

        // then
        assertThat(result.getName()).isEqualTo("NovaFlow");
        assertThat(result.getDescription()).isEqualTo("Backend Spring Boot");

        verify(repository).existsByName("NovaFlow");
        verify(mapper).toEntity(request);
        verify(repository).save(entityToSave);
    }

    @Test
    void getAll() {
        // given
        Project p1 = Project.builder()
                .name("NovaFlow")
                .description("Backend Spring Boot")
                .build();

        Project p2 = Project.builder()
                .name("NovaStream")
                .description("Backend Spring Boot Reactive")
                .build();

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
        Project project =Project.builder()
                .name("NovaFlow")
                .description("Backend Spring Boot")
                .build();

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