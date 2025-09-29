package com.example.bookmyshow.service;

import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatType;
import com.example.bookmyshow.repository.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;
    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {this.showSeatTypeRepository = showSeatTypeRepository;}
    public double calculatePrice(List<ShowSeat> showSeats){

        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(showSeats.get(0).getShow());
        double amount = 0.0;
        for(ShowSeat showSeat : showSeats){
            for(ShowSeatType showSeatType : showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
