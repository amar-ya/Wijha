package com.example.Wijha.Repository;

import com.example.Wijha.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
    @Query("select c from Customer c where c.name = :name")
    Optional<Customer> findUserByUserName(String name);
}
