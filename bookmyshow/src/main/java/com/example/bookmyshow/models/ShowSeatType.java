package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private SeatType seatType;
    private double price;
    @ManyToOne
    private Show show;
}


/*
    1                       1
    ShowSeatType            SeatType
    M                        1

    1                       1
    ShowSeatType            Show
    M                        1
 */