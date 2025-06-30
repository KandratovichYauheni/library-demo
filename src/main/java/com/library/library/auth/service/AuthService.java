package com.library.library.auth.service;

import com.library.library.auth.dto.AuthResponse;
import com.library.library.auth.dto.LoginRequest;
import com.library.library.auth.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
}
