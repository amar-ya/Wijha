package com.example.Wijha.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingSeat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "bookingseat")
    @PrimaryKeyJoinColumn
    private Booking booking;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bookingseat")
    @PrimaryKeyJoinColumn
    private Seat seat;
}
