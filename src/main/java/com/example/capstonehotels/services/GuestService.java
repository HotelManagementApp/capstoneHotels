package com.example.capstonehotels.services;

import com.example.capstonehotels.data.model.Guest;
import com.example.capstonehotels.dtos.request.BookRoomRequest;
import com.example.capstonehotels.dtos.request.BookingRequest;
import com.example.capstonehotels.dtos.request.PaymentRequest;
import com.example.capstonehotels.dtos.response.PaymentResponse;
import com.example.capstonehotels.dtos.response.Response;

import java.io.IOException;
import java.util.List;

public interface GuestService {
    Response makeRoomReservation(BookRoomRequest bookRoomRequest);

    PaymentResponse makePayment(String telephoneNumber, PaymentRequest paymentRequest) throws IOException;

    Guest findBookingById(BookingRequest findBookingRequest);

    Response cancelBooking(BookingRequest cancelBookingRequest);
}
