package com.example.Wijha.Service;

import com.example.Wijha.Repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatService
{
    private final SeatRepository seatRepository;
}
