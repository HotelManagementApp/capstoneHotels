package com.example.capstonehotels.services;

import com.example.capstonehotels.dtos.request.BookRoomRequest;
import com.example.capstonehotels.dtos.request.PaymentRequest;
import com.example.capstonehotels.dtos.response.PaymentResponse;
import com.example.capstonehotels.dtos.response.Response;

import java.io.IOException;

public interface GuestService {
    Response makeRoomReservation(BookRoomRequest bookRoomRequest);

    PaymentResponse makePayment(String telephoneNumber, PaymentRequest paymentRequest) throws IOException;

    Response cancelBooking(String guestId);
}
