package com.example.Wijha.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private LocalDateTime event_date;

    private LocalDateTime creation_date;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "event",orphanRemoval = true)
    private List<Booking> bookings;

    @ManyToOne
    @JsonIgnore
    private Organizer organizer;

    @OneToOne
    @JsonIgnore
    private Venue venue;
}
