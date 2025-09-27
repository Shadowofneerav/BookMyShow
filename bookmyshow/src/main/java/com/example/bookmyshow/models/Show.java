package com.example.bookmyshow.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Show extends BaseModel {
    private Movie movie;
    private Theatre theatre;
    private Screen screen;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Feature> features;
}
