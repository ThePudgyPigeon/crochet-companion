package com.portfolio.crochetcompanion.controller;

import com.portfolio.crochetcompanion.model.Project;
import com.portfolio.crochetcompanion.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/api/projects")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @GetMapping
    public List<Project> list(Principal principal) {
        return projectService.getAllProjectsByUser(principal);
    }

    @GetMapping(path="/{id}")
    public Project get(@PathVariable Long id) {
        return projectService.getProject(id);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project, Principal principal) {
        return projectService.createProject(project, principal);
    }

    @PutMapping(path="/{id}")
    public Project updateProject(@RequestBody Project project, @PathVariable Long id) {
        return null;
    }

    @DeleteMapping(path="/{id}")
    public Project deleteProject(@PathVariable Long id) {
        return null;
    }

    //add stitch to project
    //projects/id/stitches


}
