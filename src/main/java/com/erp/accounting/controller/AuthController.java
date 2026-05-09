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
import java.util.Optional;

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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByUsernameAndTenantId(
                loginRequest.getUsername(),
                loginRequest.getTenantId()
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
