package com.example.bookmyshow.service;

import com.example.bookmyshow.exception.SeatNotAvaliableException;
import com.example.bookmyshow.exception.UserNotFoundException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repository.ShowSeatRepository;
import com.example.bookmyshow.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;
    public BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository, PriceCalculatorService priceCalculatorService) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(List<Long> showSeatIds, Long userId) throws UserNotFoundException, SeatNotAvaliableException {
        Optional<User>  user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User not found userId : " + userId);
        }
        List<ShowSeat> showSeats = new ArrayList<>();
        for(Long showSeatId : showSeatIds){
            ShowSeat showSeat = showSeatRepository.findById(showSeatId).orElse(null);
            if(showSeat == null || showSeat.getSeatStatus().equals(ShowSeatStatus.BLOCKED)){
                throw new SeatNotAvaliableException("Seat is not available Seat Id : " +showSeatId);
            }
            showSeats.add(showSeat);
        }
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat : showSeats){
            showSeat.setSeatStatus(ShowSeatStatus.BLOCKED);
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        Booking booking = new Booking();
        booking.setUser(user.get());
        booking.setShows(savedShowSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setPrice(priceCalculatorService.calculatePrice(showSeats));
        return booking;
    }
}
