package com.example.Wijha.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
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

    String email;

    String name;
    String password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer",orphanRemoval = true)
    private List<Booking> bookings;
}
