package com.example.Wijha.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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

    private String status;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "booking")
    @JsonIgnore
    private List<BookingSeat> bookingSeats;

    private LocalDateTime booked_at;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JsonIgnore
    private Event event;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "booking")
    @JsonIgnore
    private Payment payment;
}
