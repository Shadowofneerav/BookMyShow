package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.print.Book;
import java.util.List;

@Data
@Entity(name = "screens")
public class Screen extends BaseModel {
    private String name;
    @OneToMany
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    private ScreenStatus screenStatus;
}



/*
    1               M
    Screen          Seat
    1               1


 */
