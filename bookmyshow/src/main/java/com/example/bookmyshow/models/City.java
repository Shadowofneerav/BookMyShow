package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "cities")
public class City extends BaseModel {
    private String cityName;
    @OneToMany
    @JoinColumn(name = "cityId")
    private List<Theatre> theatres;
}



/*
    1               M
    City            Theatre
    1               1
 */