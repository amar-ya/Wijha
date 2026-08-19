package com.example.Wijha.Controller;

import com.example.Wijha.Service.BookingSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking_seat")
@RequiredArgsConstructor
public class BookingSeatController
{
    private final BookingSeatService bookingSeatService;
}
