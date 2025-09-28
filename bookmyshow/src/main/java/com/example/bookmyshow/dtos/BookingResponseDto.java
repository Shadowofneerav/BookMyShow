package com.example.bookmyshow.dtos;

import com.example.bookmyshow.models.Booking;
import lombok.Data;

@Data
public class BookingResponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;
}
