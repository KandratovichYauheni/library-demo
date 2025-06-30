package com.library.library.auth;

import com.library.library.auth.dto.AuthResponse;
import com.library.library.auth.dto.LoginRequest;
import com.library.library.auth.dto.RegisterRequest;
import com.library.library.auth.entity.Role;
import com.library.library.auth.entity.User;
import com.library.library.auth.service.AuthServiceImpl;
import com.library.library.auth.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {
    @Mock
    UserService userService;
    @Mock
    PasswordEncoder encoder;
    @InjectMocks
    AuthServiceImpl auth;

    private User sampleUser;

    @BeforeEach
    void setup() {
        Role r = new Role(1,"USER","");
        sampleUser = User.builder()
                .username("u").email("e").password("HASH")
                .roles(Set.of(r)).build();
    }

    @Test
    void register_delegatesToUserService() {
        RegisterRequest req = new RegisterRequest("u","e","pwd");
        when(userService.register("u","e","pwd"))
                .thenReturn(sampleUser);

        AuthResponse resp = auth.register(req);

        assertEquals("u", resp.username());
        assertEquals("e", resp.email());
        assertTrue(resp.roles().contains("USER"));
    }

    @Test
    void login_success() {
        LoginRequest req = new LoginRequest("u","pwd");
        when(userService.findByUsername("u"))
                .thenReturn(Optional.of(sampleUser));
        when(encoder.matches("pwd","HASH")).thenReturn(true);

        AuthResponse resp = auth.login(req);

        assertEquals("u", resp.username());
    }

    @Test
    void login_userNotFound() {
        when(userService.findByUsername("x")).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class,
                () -> auth.login(new LoginRequest("x","y")));
    }

    @Test
    void login_badPassword() {
        when(userService.findByUsername("u"))
                .thenReturn(Optional.of(sampleUser));
        when(encoder.matches(any(), any())).thenReturn(false);

        assertThrows(ResponseStatusException.class,
                () -> auth.login(new LoginRequest("u","wrong")));
    }
}
