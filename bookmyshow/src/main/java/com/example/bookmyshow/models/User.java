package com.example.bookmyshow.models;

import lombok.Data;

@Data
public class User extends BaseModel {
    private String userName;
    private String email;
    private String password;
}
