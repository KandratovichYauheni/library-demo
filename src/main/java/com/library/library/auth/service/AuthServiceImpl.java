package com.library.library.auth.service;

import com.library.library.auth.dto.AuthResponse;
import com.library.library.auth.dto.LoginRequest;
import com.library.library.auth.dto.RegisterRequest;
import com.library.library.auth.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        User user = userService.register(registerRequest.username(), registerRequest.email(), registerRequest.password());
        return toDto(user);
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        User user = userService.findByUsername(loginRequest.username()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
        return toDto(user);
    }

    private AuthResponse toDto(User user) {
        return new AuthResponse(
                user.getUsername(),
                user.getEmail(),
                user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toSet())
        );
    }
}
