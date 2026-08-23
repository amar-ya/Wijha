package com.example.Wijha.Controller;

import com.example.Wijha.Dto.AuthResponse;
import com.example.Wijha.Dto.CustomerRegisterRequest;
import com.example.Wijha.Dto.LoginRequest;
import com.example.Wijha.Dto.OrganizerRegisterRequest;
import com.example.Wijha.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController
{
    private final AuthService authService;

    @PostMapping("/register/customer")
    public ResponseEntity<AuthResponse> registerCustomer(@Valid @RequestBody CustomerRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerCustomer(request));
    }

    @PostMapping("/register/organizer")
    public ResponseEntity<AuthResponse> registerOrganizer(@Valid @RequestBody OrganizerRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerOrganizer(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication) {
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String role = user.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse("");

        return ResponseEntity.ok(Map.of(
                "email", user.getUsername(),
                "role", role
        ));
    }
}
