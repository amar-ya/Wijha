package com.example.Wijha.Repository;

import com.example.Wijha.Model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
    Optional<Organizer> findByEmail(String email);
}
