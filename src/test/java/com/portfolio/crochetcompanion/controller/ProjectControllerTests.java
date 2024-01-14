package com.portfolio.crochetcompanion.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.crochetcompanion.dto.CreateProjectRequest;
import com.portfolio.crochetcompanion.dto.CreateProjectResponse;
import com.portfolio.crochetcompanion.model.CrochetStitch;
import com.portfolio.crochetcompanion.model.Project;
import com.portfolio.crochetcompanion.model.auth.User;
import com.portfolio.crochetcompanion.service.ProjectService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = ProjectController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class ProjectControllerTests {

    private final User USER = new User("stitcher", "person@email.com", "sausages");

    Project PROJECT_1 = new Project(1L, "Teddy Bear", USER);

    Project PROJECT_2 = new Project(2L, "Yellow Submarine", USER);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void list_returnsAllProjects() throws Exception {
        List<Project> projects = List.of(PROJECT_1, PROJECT_2);
        when(projectService.getAllProjects(Mockito.any()))
                .thenReturn(projects);

        ResultActions response = mockMvc.perform(get("/api/projects"));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.size()", CoreMatchers.is(2)));
    }

    @Test
    public void getProject_returnsProject() throws Exception {
        when(projectService.getProject(Mockito.anyLong(), Mockito.any()))
                .thenReturn(PROJECT_1);

        ResultActions response = mockMvc.perform(get("/api/projects/{id}", "1"));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.projectName", CoreMatchers.is(PROJECT_1.getProjectName())));
    }

    @Test
    public void createProject_returnsCreateProjectResponse() throws Exception {
        CreateProjectRequest mockRequest = new CreateProjectRequest("Pikachu", Set.of(new CrochetStitch()));
        CreateProjectResponse mockResponse = new CreateProjectResponse("Pikachu");
        when(projectService.createProject(Mockito.any(), Mockito.any()))
                .thenReturn(mockResponse);

        ResultActions response = mockMvc.perform(post("/api/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockRequest)));

        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.projectName", CoreMatchers.is(mockResponse.getProjectName())));
    }

}
