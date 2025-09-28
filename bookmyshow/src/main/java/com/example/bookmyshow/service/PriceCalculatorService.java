package com.example.bookmyshow.service;

import com.example.bookmyshow.models.ShowSeat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    public double calculatePrice(List<ShowSeat> showSeats){
        return   0.1;
    }
}
