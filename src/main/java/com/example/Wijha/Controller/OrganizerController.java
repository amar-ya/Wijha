package com.example.Wijha.Controller;

import com.example.Wijha.Service.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/organizer")
@RequiredArgsConstructor
public class OrganizerController
{
    private final OrganizerService organizerService;
}
