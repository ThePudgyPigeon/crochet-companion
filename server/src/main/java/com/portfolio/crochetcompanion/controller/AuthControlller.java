package com.portfolio.crochetcompanion.controller;

import com.portfolio.crochetcompanion.model.auth.ERole;
import com.portfolio.crochetcompanion.model.auth.Role;
import com.portfolio.crochetcompanion.model.auth.User;
import com.portfolio.crochetcompanion.payload.request.LoginRequest;
import com.portfolio.crochetcompanion.payload.request.SignupRequest;
import com.portfolio.crochetcompanion.payload.response.JwtResponse;
import com.portfolio.crochetcompanion.payload.response.MessageResponse;
import com.portfolio.crochetcompanion.repository.RoleRepository;
import com.portfolio.crochetcompanion.repository.UserRepository;
import com.portfolio.crochetcompanion.security.jwt.JwtUtils;
import com.portfolio.crochetcompanion.security.services.UserDetailsImpl;
import com.portfolio.crochetcompanion.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthControlller {

    @Autowired
    AuthService authService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public User registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        return authService.registerUser(signUpRequest);
    }

    @PostMapping("/signin")
    public JwtResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }
}
