package com.example.spring_boot.project.repository;

import com.example.spring_boot.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> getByName(String name);

    Boolean existsByName(String name);
}
