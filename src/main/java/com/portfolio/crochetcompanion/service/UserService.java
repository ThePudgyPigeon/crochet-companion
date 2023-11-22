package com.portfolio.crochetcompanion.service;

import com.portfolio.crochetcompanion.model.auth.ERole;
import com.portfolio.crochetcompanion.model.auth.Role;
import com.portfolio.crochetcompanion.model.auth.User;
import com.portfolio.crochetcompanion.payload.request.UserPatchRequest;
import com.portfolio.crochetcompanion.repository.RoleRepository;
import com.portfolio.crochetcompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<String> getRoles() {
        return List.of("student", "admin");
    }

    public User updateUser(Long userId, UserPatchRequest user) {
        Optional<User> optUser = userRepository.findById(userId);
        if (optUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }

        User existingUser = optUser.get();
        existingUser.setId(userId);
        existingUser.setUsername(user.getUsername());
        existingUser.setRoles(mapRoles(user.getRoles()));

        return userRepository.save(existingUser);
    }
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    private Set<Role> mapRoles(Set<String> strRoles) {
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "user" -> {
                    Role studentRole = roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(studentRole);
                }
                case "admin" -> {
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                }
                default -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid role.");
                }
            }
        });

        return roles;
    }

}
