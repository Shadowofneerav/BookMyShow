package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "shows")
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
//    private Theatre theatre;
    @ManyToOne
    private Screen screen;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}


/*

    1           1
    Show        Movie
    M            1


    1           1
    Show        Screen
    M            1
 */