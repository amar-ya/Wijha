package com.example.Wijha.Service;

import com.example.Wijha.Model.Customer;
import com.example.Wijha.Model.Organizer;
import com.example.Wijha.Repository.CustomerRepository;
import com.example.Wijha.Repository.OrganizerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private final CustomerRepository customerRepository;
    private final OrganizerRepository organizerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerRepository.findByEmail(email)
                .map(this::toUserDetails)
                .or(() -> organizerRepository.findByEmail(email).map(this::toUserDetails))
                .orElseThrow(() -> new UsernameNotFoundException("email or password is incorrect"));
    }

    private UserDetails toUserDetails(Customer customer) {
        return org.springframework.security.core.userdetails.User
                .withUsername(customer.getEmail())
                .password(customer.getPassword())
                .authorities("CUSTOMER")
                .build();
    }

    private UserDetails toUserDetails(Organizer organizer) {
        return org.springframework.security.core.userdetails.User
                .withUsername(organizer.getEmail())
                .password(organizer.getPassword())
                .authorities("ORGANIZER")
                .build();
    }
}
