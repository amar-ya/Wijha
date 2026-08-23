package com.example.Wijha.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email
    @Column(unique = true, nullable = false)
    String email;

    String name;

    @JsonIgnore
    String password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer",orphanRemoval = true)
    private List<Booking> bookings;
}
