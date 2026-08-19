package com.example.Wijha.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    private Float amount;

    private enum status
    {
        PAID,
        UNPAID
    }

    private Integer providerRefrence;

    private LocalDateTime creationDate;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "payment")
    @JsonIgnore
    private Booking booking;
}
