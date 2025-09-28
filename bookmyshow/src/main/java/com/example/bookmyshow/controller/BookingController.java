package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.BookingResponseDto;
import com.example.bookmyshow.dtos.CreateBookingRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @PostMapping
    public BookingResponseDto createBooking(@RequestBody CreateBookingRequestDto createBookingRequestDto)
    {
        return null;
    }
}
