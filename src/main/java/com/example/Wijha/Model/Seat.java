package com.example.Wijha.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer seatNumber;

    private Double price;

    private enum status
    {
        PAID,
        UNPAID,
        RESERVED
    }

    @ManyToOne
    @JsonIgnore
    private Event event;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Booking booking;
}
