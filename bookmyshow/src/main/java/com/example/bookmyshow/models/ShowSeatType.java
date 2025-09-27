package com.example.bookmyshow.models;

import lombok.Data;

@Data
public class ShowSeatType extends BaseModel {
    private SeatType seatType;
    private double price;
    private Show show;
}
