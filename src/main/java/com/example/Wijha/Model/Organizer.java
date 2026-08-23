package com.example.Wijha.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Organizer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @JsonIgnore
    private String password;

    private LocalDateTime creationDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizer")
    @JsonIgnore
    private List<Event> events;




}
