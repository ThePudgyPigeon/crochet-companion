package com.portfolio.crochetcompanion.controller;

import com.portfolio.crochetcompanion.model.Project;
import com.portfolio.crochetcompanion.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path="/projects")
@RequiredArgsConstructor
@PreAuthorize("hasRole('USER')")
public class ProjectController {

    ProjectService projectService;
    @GetMapping
    public List<Project> list(Principal principal) {
        return projectService.getAllProjectsByUser(principal);
    }

    @GetMapping(path="/{id}")
    public Project get(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public Project createOrSaveProject(@PathVariable Long id) {
        return null;
    }

    @PutMapping(path="/{id}")
    public Project updateProject(@RequestBody Project newProject, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping(path="/{id}")
    public Project deleteProject(@PathVariable Long id) {
        return null;
    }


}
