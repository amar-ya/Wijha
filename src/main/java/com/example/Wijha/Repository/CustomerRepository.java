package com.example.Wijha.Repository;

import com.example.Wijha.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    Optional<Customer> findByEmail(String email);
}
