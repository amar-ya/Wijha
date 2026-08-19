package com.example.Wijha.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private enum status
    {
        booked,
        unbooked,
        reserved
    }

    @OneToOne
    @MapsId
    @JsonIgnore
    private BookingSeat bookingSeat;

    private LocalDateTime booked_at;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JsonIgnore
    private Event event;

    @OneToOne
    @JsonIgnore
    private Payment payment;
}
