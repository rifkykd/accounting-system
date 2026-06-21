package com.erp.accounting.controller;

import com.erp.accounting.dto.LoginRequest;
import com.erp.accounting.dto.LoginResponse;
import com.erp.accounting.model.User;
import com.erp.accounting.repository.UserRepository;
import com.erp.accounting.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody LoginRequest signupRequest) {
        // Check if user already exists
        Optional<User> existingUser = userRepository.findByUsername(signupRequest.getUsername());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(null, null, null, null, "User already exists"));
        }

        // Create new user
        User newUser = new User();
        newUser.setUsername(signupRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        newUser.setTenantId(signupRequest.getTenantId() != null ? signupRequest.getTenantId() : "default");
        newUser.setEmail(signupRequest.getUsername() + "@example.com");
        newUser.setFirstName("User");
        newUser.setLastName("Account");
        newUser.setActive(true);
        Set<String> roles = new HashSet<>();
        roles.add("USER");
        newUser.setRoles(roles);
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        // Save user to MongoDB
        User savedUser = userRepository.save(newUser);

        // Generate token
        String token = jwtTokenProvider.generateToken(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getTenantId(),
                savedUser.getRoles()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(LoginResponse.builder()
                .token(token)
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .tenantId(savedUser.getTenantId())
                .message("Account created successfully")
                .build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByUsernameAndTenantId(
                loginRequest.getUsername(),
                loginRequest.getTenantId() != null ? loginRequest.getTenantId() : "default"
        );

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(null, null, null, null, "Invalid credentials"));
        }

        User user = userOptional.get();
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(null, null, null, null, "Invalid credentials"));
        }

        String token = jwtTokenProvider.generateToken(
                user.getId(),
                user.getUsername(),
                user.getTenantId(),
                user.getRoles()
        );

        return ResponseEntity.ok(LoginResponse.builder()
                .token(token)
                .username(user.getUsername())
                .email(user.getEmail())
                .tenantId(user.getTenantId())
                .message("Login successful")
                .build());
    }
}
