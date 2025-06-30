package com.library.library.auth.dto;

import java.util.Set;

public record AuthResponse(
        String username,
        String email,
        Set<String> roles
) {}
