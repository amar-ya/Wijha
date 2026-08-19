package com.example.Wijha.Service;

import com.example.Wijha.Repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService
{
    private final BookingRepository bookingRepository;
}
