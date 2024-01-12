package com.portfolio.crochetcompanion.service;

import com.portfolio.crochetcompanion.dto.CreateProjectRequest;
import com.portfolio.crochetcompanion.model.CrochetStitch;
import com.portfolio.crochetcompanion.model.Project;
import com.portfolio.crochetcompanion.model.auth.User;
import com.portfolio.crochetcompanion.repository.ProjectRepository;
import com.portfolio.crochetcompanion.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    private final User USER = new User("stitcher", "person@email.com", "sausages");

    Project PROJECT_1 = new Project("Teddy Bear");

    Project PROJECT_2 = new Project("Yellow Submarine");

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    public void getAllProjects_returnsAllUserProjects() {
        when(projectRepository.findByUser(Mockito.any()))
                .thenReturn(List.of(PROJECT_1, PROJECT_2));

        User mockUser = new User();
        mockUser.setId(5L);
        when(userRepository.findByUsername(Mockito.any())).thenReturn(Optional.of(mockUser));

        List<Project> projects = projectService.getAllProjects(Mockito.mock(Principal.class));

        Assertions.assertThat(projects).hasSize(2);
    }



}