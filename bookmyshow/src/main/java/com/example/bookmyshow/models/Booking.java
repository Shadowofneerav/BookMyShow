package com.example.bookmyshow.models;

import lombok.Data;

import java.util.List;
@Data
public class Booking extends BaseModel{
    private User user;
    private BookingStatus bookingStatus;
    private List<Payment> payments;
    private double price;
    private List<ShowSeat> shows;
}
