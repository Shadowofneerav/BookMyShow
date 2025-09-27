package com.example.bookmyshow.models;

import lombok.Data;

import java.util.List;

@Data
public class Theatre extends BaseModel {
    private String theatreName;
    private List<Screen> screens;
}
