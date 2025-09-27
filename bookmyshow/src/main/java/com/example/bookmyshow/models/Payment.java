package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;
@Data
@Entity(name = "payments")
public class Payment extends BaseModel {
    private double amount;
    private String  referenceNumber;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
