package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "seats")
public class Seat extends BaseModel{
    private String seatNo;
    private int rowValue;
    private int colValue;
    @ManyToOne
    private SeatType seatType;
}


/*
    1           1
    Seat        SeatType
    M           1
 */