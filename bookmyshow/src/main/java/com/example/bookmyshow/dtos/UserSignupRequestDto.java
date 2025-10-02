package com.example.bookmyshow.dtos;

import lombok.Data;

@Data
public class UserSignupRequestDto {
    private String name;
    private String email;
    private String password;
}
