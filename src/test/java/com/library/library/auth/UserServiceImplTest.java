package com.library.library.auth;

import com.library.library.auth.entity.Role;
import com.library.library.auth.entity.User;
import com.library.library.auth.repository.RoleRepository;
import com.library.library.auth.repository.UserRepository;
import com.library.library.auth.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    RoleRepository roleRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    PasswordEncoder passwordEncoder;
    @InjectMocks
    UserServiceImpl userService;

//    @Test
//    void register_user() {
//        when(userRepository.findByUsername("Aleis")).thenReturn(Optional.empty());
//        when(roleRepository.findByName("ADMIN")).thenReturn(Optional.of(new Role(1, "ADMIN", "Administrator role with full access")));
//        when(roleRepository.findByName("USER")).thenReturn(Optional.of(new Role(2, "USER", "Standard user role with limited access")));
//        when(passwordEncoder.encode("pass")).thenReturn("HASH");
//        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));
//        User u = userService.register("alice","a@b.c","pass");
//        assertEquals("alice", u.getUsername());
//        assertEquals("a@b.c", u.getEmail());
//        assertEquals("HASH", u.getPassword());
//        assertTrue(u.getRoles().stream().anyMatch(r->r.getName().equals("USER")));
//    }
//
//    @Test
//    void register_usernameTaken() {
//        when(userRepository.findByUsername("bob")).thenReturn(Optional.of(new User()));
//        assertThrows(IllegalArgumentException.class, () -> userService.register("bob","e@f.g","x"));
//    }
//
//    @Test
//    void register_noUserRole() {
//        when(userRepository.findByUsername("joe")).thenReturn(Optional.empty());
//        when(roleRepository.findByName("USER")).thenReturn(Optional.empty());
//        assertThrows(IllegalStateException.class, () -> userService.register("joe","j@k.l","pwd"));
//    }
}
