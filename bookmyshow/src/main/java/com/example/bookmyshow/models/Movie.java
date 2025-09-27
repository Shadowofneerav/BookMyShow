package com.example.bookmyshow.models;

import lombok.Data;

@Data
public class Movie extends BaseModel {
    private String movie;
    private double rating;
}
