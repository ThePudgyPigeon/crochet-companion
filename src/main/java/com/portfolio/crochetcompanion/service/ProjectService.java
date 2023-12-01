package com.portfolio.crochetcompanion.service;

import com.portfolio.crochetcompanion.model.CrochetStitch;
import com.portfolio.crochetcompanion.model.Project;
import com.portfolio.crochetcompanion.model.auth.ERole;
import com.portfolio.crochetcompanion.model.auth.User;
import com.portfolio.crochetcompanion.repository.ProjectRepository;
import com.portfolio.crochetcompanion.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProjectsByUser(Principal principal) {
        Optional<User> user = userRepository.findByUsername(principal.getName());
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Logged in user does not exist.");
        }
        return projectRepository.findByUser(user.get());
    }

    public Project getProject(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Crochet Stitch not found.");
        }
        return project.get();
    }

    public Project createProject(Project project, Principal principal) {
        Long userId = getUserId(principal);
        User user = new User(userId);
        project.setUser(user);

        List<Project> prevProjects = projectRepository.findByUser(user);
        for (Project p: prevProjects) {
            if (project.getProjectName().equals(p.getProjectName())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "You already have a project by this name!");
            }
        }

        Project savedProject = projectRepository.save(project);
        Optional<Project> optProject = projectRepository.findById(savedProject.getProjectId());

        if (optProject.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Project not found");
        }

        return optProject.get();

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

    private Long getUserId(Principal principal) {
        Optional<User> user = userRepository.findByUsername(principal.getName());
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Logged in user does not exist.");
        }
        return user.get().getId();
    }


}
