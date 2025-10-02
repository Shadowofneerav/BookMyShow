package com.example.bookmyshow.dtos;

import lombok.Data;

@Data
public class UserSignupResponseDto {
    private String email;
    private SignupStatus signupStatus;
}
