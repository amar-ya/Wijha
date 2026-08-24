package com.example.Wijha.Controller;

import com.example.Wijha.Api.ApiResponse;
import com.example.Wijha.Model.Event;
import com.example.Wijha.Service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventController
{
    private final EventService eventService;

    @GetMapping("/get/all")
    public ResponseEntity<?>  getAllEvents()
    {
        return ResponseEntity.ok(eventService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEvent(@PathVariable Integer id)
    {
        return ResponseEntity.status(200).body(eventService.findEventsByOrganizerId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEvent(@RequestBody @Valid Event event, Authentication auth){
        eventService.addEvent(event, auth.getName());
        return ResponseEntity.status(200).body(new ApiResponse("Event created successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEvent(@PathVariable Integer id, @RequestBody @Valid Event event, Authentication auth){
        eventService.updateEvent(id ,event, auth.getName());
        return ResponseEntity.status(200).body(new ApiResponse("Event updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Integer id, Authentication auth){
        eventService.deleteEvent(id, auth.getName());
        return ResponseEntity.status(200).body(new ApiResponse("Event deleted successfully"));
    }
}
