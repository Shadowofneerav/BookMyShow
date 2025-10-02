package com.example.bookmyshow.dtos;

import lombok.Data;

@Data
public class UserSignInRequestDto {
    private String email;
    private String password;
}
