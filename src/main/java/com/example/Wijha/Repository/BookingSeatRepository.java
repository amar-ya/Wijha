package com.example.Wijha.Repository;

import com.example.Wijha.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingSeatRepository extends JpaRepository<Booking, Integer> {
}
