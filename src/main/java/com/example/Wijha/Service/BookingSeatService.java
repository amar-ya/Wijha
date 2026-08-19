package com.example.Wijha.Service;

import com.example.Wijha.Repository.BookingSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingSeatService
{
    private final BookingSeatRepository bookingRepository;
}
