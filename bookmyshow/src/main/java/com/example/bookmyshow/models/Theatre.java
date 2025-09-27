package com.example.bookmyshow.models;

import lombok.Data;

import java.util.List;

@Data
public class Theatre extends BaseModel {
    private String theatreName;
    private String address;
    private List<Screen> screens;
}
