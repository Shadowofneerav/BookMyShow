package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.BookingResponseDto;
import com.example.bookmyshow.dtos.CreateBookingRequestDto;
import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.exception.SeatNotAvaliableException;
import com.example.bookmyshow.exception.UserNotFoundException;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService){this.bookingService = bookingService;}
    @PostMapping
    public BookingResponseDto createBooking(@RequestBody CreateBookingRequestDto createBookingRequestDto) throws UserNotFoundException, SeatNotAvaliableException {
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        Booking booking = null;
        booking = bookingService.createBooking(createBookingRequestDto.getShowSeatIds(),createBookingRequestDto.getUserId());

        bookingResponseDto.setBooking(booking);
        bookingResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        if(booking==null){
            bookingResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return bookingResponseDto;
    }
}
