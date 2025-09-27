package com.example.bookmyshow.models;

import lombok.Data;

import java.awt.print.Book;
import java.util.List;

@Data
public class Screen extends BaseModel {
    private String name;
    private List<Seat> seats;
    private List<Feature> features;
    private ScreenStatus screenStatus;
}
