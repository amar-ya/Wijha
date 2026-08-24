package com.example.Wijha.Repository;

import com.example.Wijha.Model.Event;
import com.example.Wijha.Model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query("select e from Event e where e.organizer.id =:organizerId ")
    List<Event> findByOrganizer(Integer organizerId);
}
