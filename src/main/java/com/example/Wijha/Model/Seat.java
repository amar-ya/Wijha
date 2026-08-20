package com.example.Wijha.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private String status;

    @ManyToOne
    @JsonIgnore
    private Event event;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "seat")
    @JsonIgnore
    private List<BookingSeat> bookingSeat;
}
