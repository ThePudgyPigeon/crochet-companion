package com.portfolio.crochetcompanion.service;

import com.portfolio.crochetcompanion.dto.CreateProjectRequest;
import com.portfolio.crochetcompanion.dto.CreateProjectResponse;
import com.portfolio.crochetcompanion.model.Project;
import com.portfolio.crochetcompanion.model.auth.User;
import com.portfolio.crochetcompanion.repository.ProjectRepository;
import com.portfolio.crochetcompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProjects(Principal principal) {
        User user = getUser(principal);
        return projectRepository.findByUser(user);
    }

    public Project getProject(Long id, Principal principal) {
        User user = getUser(principal);

        Project project = projectRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Project does not exist."));

        if (!user.getId().equals(project.getUser().getId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Unauthorized user.");
        }

        return project;
    }

    public CreateProjectResponse createProject(CreateProjectRequest request, Principal principal) {
        Project createdProject = new Project();
        User user = getUser(principal);

        if (projectRepository.existsByProjectName(request.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Project name already exists.");
        }

        createdProject.setUser(user);
        createdProject.setProjectName(request.getName());
        createdProject.setCrochetStitches(request.getCrochetStitches());

        projectRepository.save(createdProject);

        return new CreateProjectResponse(createdProject.getProjectName());
    }

//    public Project updateProject(Long id, Project project, Principal principal) {
//        Long userId = getUserId(principal);
//        if (!userId.equals(project.getProjectId())) {
//            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not authorized to modify project.");
//        }
//
//        Optional<Project> optProject = projectRepository.findById(id);
//        if (optProject.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found!");
//        }
//
//        Project existingProject = optProject.get();
//        existingProject.setProjectName(project.getProjectName());
//        existingProject.setCrochetStitches(project.getCrochetStitches());
//
//        return projectRepository.save(existingProject);
//    }

    private User getUser(Principal principal) {
        Optional<User> user = userRepository.findByUsername(principal.getName());
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Logged in user does not exist.");
        }
        return user.get();
    }


}
