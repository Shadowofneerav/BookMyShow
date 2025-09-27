package com.example.bookmyshow.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Show extends BaseModel {
    private String movieName;
    private Theatre theatre;
    private Screen screen;
    private LocalDateTime movieTime;
}
