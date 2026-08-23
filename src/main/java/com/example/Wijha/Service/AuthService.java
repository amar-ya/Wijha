package com.example.Wijha.Service;

import com.example.Wijha.Api.ApiException;
import com.example.Wijha.Config.JWT.JwtUtil;
import com.example.Wijha.Dto.AuthResponse;
import com.example.Wijha.Dto.CustomerRegisterRequest;
import com.example.Wijha.Dto.LoginRequest;
import com.example.Wijha.Dto.OrganizerRegisterRequest;
import com.example.Wijha.Model.Customer;
import com.example.Wijha.Model.Organizer;
import com.example.Wijha.Repository.CustomerRepository;
import com.example.Wijha.Repository.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService
{
    private final CustomerRepository customerRepository;
    private final OrganizerRepository organizerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponse registerCustomer(CustomerRegisterRequest request) {
        ensureEmailIsFree(request.getEmail());

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPassword(passwordEncoder.encode(request.getPassword()));
        customerRepository.save(customer);

        String token = jwtUtil.generateToken(userDetails(customer.getEmail(), customer.getPassword(), "CUSTOMER"));
        return new AuthResponse(token, "CUSTOMER", customer.getId(), customer.getName(), customer.getEmail());
    }

    public AuthResponse registerOrganizer(OrganizerRegisterRequest request) {
        ensureEmailIsFree(request.getEmail());

        Organizer organizer = new Organizer();
        organizer.setName(request.getName());
        organizer.setEmail(request.getEmail());
        organizer.setPassword(passwordEncoder.encode(request.getPassword()));
        organizer.setCreationDate(LocalDateTime.now());
        organizerRepository.save(organizer);

        String token = jwtUtil.generateToken(userDetails(organizer.getEmail(), organizer.getPassword(), "ORGANIZER"));
        return new AuthResponse(token, "ORGANIZER", organizer.getId(), organizer.getName(), organizer.getEmail());
    }

    public AuthResponse login(LoginRequest request) {
        var customer = customerRepository.findByEmail(request.getEmail());
        if (customer.isPresent()) {
            Customer c = customer.get();
            if (!passwordEncoder.matches(request.getPassword(), c.getPassword())) {
                throw new ApiException("email or password is incorrect");
            }
            String token = jwtUtil.generateToken(userDetails(c.getEmail(), c.getPassword(), "CUSTOMER"));
            return new AuthResponse(token, "CUSTOMER", c.getId(), c.getName(), c.getEmail());
        }

        var organizer = organizerRepository.findByEmail(request.getEmail());
        if (organizer.isPresent()) {
            Organizer o = organizer.get();
            if (!passwordEncoder.matches(request.getPassword(), o.getPassword())) {
                throw new ApiException("email or password is incorrect");
            }
            String token = jwtUtil.generateToken(userDetails(o.getEmail(), o.getPassword(), "ORGANIZER"));
            return new AuthResponse(token, "ORGANIZER", o.getId(), o.getName(), o.getEmail());
        }

        throw new ApiException("email or password is incorrect");
    }

    private void ensureEmailIsFree(String email) {
        if (customerRepository.findByEmail(email).isPresent() || organizerRepository.findByEmail(email).isPresent()) {
            throw new ApiException("email is already in use");
        }
    }

    private UserDetails userDetails(String email, String password, String role) {
        return User.withUsername(email)
                .password(password)
                .authorities(role)
                .build();
    }
}
