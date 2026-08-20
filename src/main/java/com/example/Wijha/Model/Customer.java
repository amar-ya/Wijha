package com.example.Wijha.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

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

    @Email
    @UniqueElements
    String email;

    String name;
    String password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer",orphanRemoval = true)
    private List<Booking> bookings;
}
