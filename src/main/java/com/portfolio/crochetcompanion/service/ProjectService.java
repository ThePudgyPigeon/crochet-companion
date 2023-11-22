package com.portfolio.crochetcompanion.service;

import com.portfolio.crochetcompanion.model.Project;
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

}
