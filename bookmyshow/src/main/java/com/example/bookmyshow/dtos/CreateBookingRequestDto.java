package com.example.bookmyshow.dtos;

import lombok.Data;

import java.util.List;
@Data
public class CreateBookingRequestDto {
    private List<Long> showSeatIds;
    private Long userId;
}
