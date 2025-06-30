package com.library.library.auth.controller;

import com.library.library.auth.service.AuthService;
import com.library.library.auth.dto.AuthResponse;
import com.library.library.auth.dto.LoginRequest;
import com.library.library.auth.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Validated @RequestBody RegisterRequest req
    ) {
        AuthResponse resp = authService.register(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Validated @RequestBody LoginRequest req
    ) {
        AuthResponse resp = authService.login(req);
        return ResponseEntity.ok(resp);
    }
}
