package com.skillforge.backend.service;

import com.skillforge.backend.dto.AuthRequest;
import com.skillforge.backend.dto.AuthResponse;
import com.skillforge.backend.dto.RegisterRequest;
import com.skillforge.backend.model.Role;
import com.skillforge.backend.model.User;
import com.skillforge.backend.repository.UserRepository;
import com.skillforge.backend.config.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register_ShouldReturnToken() {
        RegisterRequest request = RegisterRequest.builder()
                .firstname("Test")
                .lastname("User")
                .email("test@example.com")
                .password("pass123")
                .build();

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));
        when(jwtService.generateToken(any())).thenReturn("test.jwt.token");

        AuthResponse response = authService.register(request);

        assertNotNull(response);
        assertEquals("test.jwt.token", response.getToken());
        verify(userRepository, times(1)).save(any());
    }


    @Test
    void login_ShouldReturnToken() {
        AuthRequest request = AuthRequest.builder()
                .email("test@example.com")
                .password("pass123")
                .build();

        User user = User.builder()
                .email(request.getEmail())
                .password("encodedPassword")
                .role(Role.USER)
                .build();

        when(userRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(user));
        when(jwtService.generateToken(user)).thenReturn("token.jwt");

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(new UsernamePasswordAuthenticationToken("email", "password"));

        AuthResponse response = authService.login(request);

        assertEquals("token.jwt", response.getToken());
        verify(authenticationManager).authenticate(any());
    }

}
