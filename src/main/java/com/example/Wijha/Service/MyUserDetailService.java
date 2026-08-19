package com.example.Wijha.Service;

import com.example.Wijha.Api.ApiException;
import com.example.Wijha.Model.Customer;
import com.example.Wijha.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private final CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer u = customerRepository.findUserByUserName(username).orElseThrow(() -> new ApiException("username or password is incorrect"));

        return org.springframework.security.core.userdetails.User
                .withUsername(u.getName())
                .password(u.getPassword())
                .build();
    }
}
