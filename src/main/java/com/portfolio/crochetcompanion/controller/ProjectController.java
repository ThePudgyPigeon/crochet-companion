package com.portfolio.crochetcompanion.controller;

import com.portfolio.crochetcompanion.dto.CreateProjectRequest;
import com.portfolio.crochetcompanion.dto.CreateProjectResponse;
import com.portfolio.crochetcompanion.model.Project;
import com.portfolio.crochetcompanion.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/api/projects")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @GetMapping
    public List<Project> list(Principal principal) {
        return projectService.getAllProjects(principal);
    }

    @GetMapping(path="/{id}")
    public Project get(@PathVariable Long id, Principal principal) {
        return projectService.getProject(id, principal);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreateProjectResponse createProject(@RequestBody CreateProjectRequest request, Principal principal) {
        return projectService.createProject(request, principal);
    }

    @PutMapping(path="/{id}")
    public Project updateProject(@RequestBody Project project, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping(path="/{id}")
    public Project deleteProject(@PathVariable Long id) {
        return null;
    }

}
