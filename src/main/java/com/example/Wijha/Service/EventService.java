package com.example.Wijha.Service;

import com.example.Wijha.Api.ApiException;
import com.example.Wijha.Model.Event;
import com.example.Wijha.Model.Organizer;
import com.example.Wijha.Repository.EventRepository;
import com.example.Wijha.Repository.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService
{
    private final EventRepository eventRepository;
    private final OrganizerRepository organizerRepository;

    public List<Event>  findAll()
    {
        return eventRepository.findAll();
    }

    public List<Event> findEventsByOrganizerId(Integer organizerId)
    {
        List<Event> events = eventRepository.findByOrganizer(organizerId);
        if (events.isEmpty()) throw new ApiException("this organizer doesnt have any events yet");

        return events;
    }

    public void addEvent(Event event, String createrEmail){
        Organizer creater = organizerRepository.findByEmail(createrEmail).orElseThrow(() -> new RuntimeException("Organizer not found"));
        event.setOrganizer(creater);
        event.setCreation_date(LocalDateTime.now());
        eventRepository.save(event);event.setCreation_date(LocalDateTime.now());
        organizerRepository.save(creater);
    }

    public void updateEvent(Integer eventId, Event UpdatedEvent, String requester){
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        Organizer org = organizerRepository.findByEmail(requester).orElseThrow(() -> new RuntimeException("Organizer not found"));
        if(event.getOrganizer()!=org){
            throw new ApiException("you cant update this event since its not yours");
        }else {
            event.setEvent_date(UpdatedEvent.getEvent_date());
            event.setTitle(UpdatedEvent.getTitle());
            event.setDescription(UpdatedEvent.getDescription());
            event.setVenue(UpdatedEvent.getVenue());
            eventRepository.save(event);
        }
    }

    public void deleteEvent(Integer eventId,  String requester ){
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        Organizer org = organizerRepository.findByEmail(requester).orElseThrow(() -> new RuntimeException("Organizer not found"));
        if(event.getOrganizer()!=org){
            throw new ApiException("you cant delete this event since its not yours");
        }else  {
            eventRepository.delete(event);
        }
    }


}
