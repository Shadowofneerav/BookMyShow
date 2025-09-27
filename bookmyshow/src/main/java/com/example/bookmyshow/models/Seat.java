package com.example.bookmyshow.models;

import lombok.Data;

@Data
public class Seat extends BaseModel{
    private String seatNo;
    private SeatType seatType;
    private int row;
    private int col;
}
