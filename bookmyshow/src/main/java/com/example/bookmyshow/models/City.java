package com.example.bookmyshow.models;

import lombok.Data;

import java.util.List;

@Data
public class City extends BaseModel {
    private String cityName;
    private List<Theatre> theatres;
}
