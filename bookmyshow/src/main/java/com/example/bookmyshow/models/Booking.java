package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity(name = "bookings")
public class Booking extends BaseModel{
    @ManyToOne
    private User user;
    @OneToMany
    private List<ShowSeat> shows;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @OneToMany
    private List<Payment> payments;
    private double price;
    private Date bookedAt;
}

/*
    1               1
    Booking         User
    M               1


    1               M
    Booking         ShowSeat
    1               1

    1               M
    Booking         Payment
   1                1
 */