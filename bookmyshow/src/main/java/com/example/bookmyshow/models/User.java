package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "users")
public class User extends BaseModel {
    private String userName;
    private String email;
    private String password;
}
