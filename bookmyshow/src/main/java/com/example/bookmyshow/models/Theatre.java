package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "theatres")
public class Theatre extends BaseModel {
    private String theatreName;
    private String address;
    @OneToMany
    @JoinColumn(name = "theatreId")
    private List<Screen> screens;
}


/*

    1               M
    Theatre         Screen
    1                1
 */