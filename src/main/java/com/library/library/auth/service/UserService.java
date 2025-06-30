package com.library.library.auth.service;

import com.library.library.auth.entity.User;

import java.util.Optional;

public interface UserService {
    User register(String username, String password, String email);
    Optional<User> findByUsername(String username);
}
