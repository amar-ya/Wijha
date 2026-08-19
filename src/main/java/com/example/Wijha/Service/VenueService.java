package com.example.Wijha.Service;

import com.example.Wijha.Repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VenueService
{
    private final VenueRepository venueRepository;
}
