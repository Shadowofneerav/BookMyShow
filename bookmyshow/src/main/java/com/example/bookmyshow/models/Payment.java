package com.example.bookmyshow.models;

import lombok.Data;

import java.util.List;
@Data
public class Payment extends BaseModel {
    private List<PaymentMode> paymentModeList;
    private PaymentStatus paymentStatus;
    private double amount;
    private String  referenceNumber;
    private List<ShowSeat>  showSeatList;
}
