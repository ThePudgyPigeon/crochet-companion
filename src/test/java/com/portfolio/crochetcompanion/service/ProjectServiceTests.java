package com.portfolio.crochetcompanion.service;

import com.portfolio.crochetcompanion.dto.CreateProjectRequest;
import com.portfolio.crochetcompanion.dto.CreateProjectResponse;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTests {

    private final User USER = new User("stitcher", "person@email.com", "sausages");

    private final Project PROJECT_1 = new Project(1L, "Teddy Bear", USER);

    private final Project PROJECT_2 = new Project(2L, "Yellow Submarine", USER);

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

    @Test
    public void getProject_returnsCorrectProject() {
        when(projectRepository.findById(Mockito.any())).thenReturn(Optional.of(PROJECT_1));

        USER.setId(1L);
        when(userRepository.findByUsername(Mockito.any())).thenReturn(Optional.of(USER));

        Project testProject = projectService.getProject(1L, Mockito.mock(Principal.class));

        Assertions.assertThat(testProject).isEqualTo(PROJECT_1);
    }

    @Test
    public void getProject_respondsWithForbiddenStatusOnIncorrectUser() {
        USER.setId(1L);
        User mockUser = new User();
        mockUser.setId(2L);
        when(userRepository.findByUsername(Mockito.any())).thenReturn(Optional.of(mockUser));

        when(projectRepository.findById(Mockito.any())).thenReturn(Optional.of(PROJECT_1));

        Assertions.assertThatThrownBy(() -> projectService.getProject(1L, Mockito.mock(Principal.class)))
                .isInstanceOf(ResponseStatusException.class)
                .hasFieldOrPropertyWithValue("status", HttpStatus.FORBIDDEN);
    }

    @Test
    public void getProject_respondsWithNotFoundOnMissingProject() {
        USER.setId(1L);
        when(userRepository.findByUsername(Mockito.any())).thenReturn(Optional.of(USER));

        Assertions.assertThatThrownBy(() -> projectService.getProject(5L, Mockito.mock(Principal.class)))
                .isInstanceOf(ResponseStatusException.class)
                .hasFieldOrPropertyWithValue("status", HttpStatus.NOT_FOUND);


    }

    @Test
    public void getUser_respondsWithServerErrorOnMissingUser() {
        Principal mockPrincipal = Mockito.mock(Principal.class);
        when(mockPrincipal.getName()).thenReturn("Guillermo");
        when(userRepository.findByUsername("Guillermo")).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> projectService.getProject(1L, mockPrincipal))
                .isInstanceOf(ResponseStatusException.class)
                .hasFieldOrPropertyWithValue("status", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void createProject_returnsCreateProjectResponse() {
        Principal mockPrincipal = Mockito.mock(Principal.class);
        CreateProjectRequest mockRequest = new CreateProjectRequest("Pikachu", Set.of(new CrochetStitch()));

        when(userRepository.findByUsername(Mockito.any())).thenReturn(Optional.of(USER));
        when(projectRepository.existsByProjectName(Mockito.any())).thenReturn(false);
        when(projectRepository.save(Mockito.any(Project.class))).thenReturn(PROJECT_2);

        CreateProjectResponse mockResponse = projectService.createProject(mockRequest, mockPrincipal);

        Assertions.assertThat(mockResponse).isNotNull();
    }

    @Test
    public void createScript_respondsWithConflictStatusOnDuplicateName() {
        CreateProjectRequest mockRequest = new CreateProjectRequest("Pikachu", Set.of(new CrochetStitch()));

        Principal mockPrincipal = Mockito.mock(Principal.class);
        when(userRepository.findByUsername(Mockito.any())).thenReturn(Optional.of(USER));
        when(projectRepository.existsByProjectName(Mockito.any())).thenReturn(true);

        Assertions.assertThatThrownBy(() -> projectService.createProject(mockRequest, mockPrincipal))
                .isInstanceOf(ResponseStatusException.class)
                .hasFieldOrPropertyWithValue("status", HttpStatus.CONFLICT);


    }


}