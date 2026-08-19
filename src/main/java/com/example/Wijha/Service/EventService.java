package com.example.Wijha.Service;

import com.example.Wijha.Repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService
{
    private final EventRepository eventRepository;
}
