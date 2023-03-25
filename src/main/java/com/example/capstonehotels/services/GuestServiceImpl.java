package com.example.capstonehotels.services;

import com.example.capstonehotels.data.model.Guest;
import com.example.capstonehotels.data.model.PaymentStatus;
import com.example.capstonehotels.data.model.RoomType;
import com.example.capstonehotels.data.repository.GuestRepository;
import com.example.capstonehotels.dtos.request.BookRoomRequest;
import com.example.capstonehotels.dtos.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public Response makeRoomReservation(BookRoomRequest bookRoomRequest) {
        Guest newGuest = new Guest();
        newGuest.setCheckinDate(bookRoomRequest.getCheckinDate());
        newGuest.setCheckoutDate(bookRoomRequest.getCheckoutDate());
        newGuest.setEmailAddress(bookRoomRequest.getEmailAddress());
        newGuest.setFirstName(bookRoomRequest.getFirstName());
        newGuest.setLastName(bookRoomRequest.getLastName());
        newGuest.setTelephoneNumber(bookRoomRequest.getTelephoneNumber());
        newGuest.setRoomType(bookRoomRequest.getRoomType());
        if(bookRoomRequest.getRoomType().equals(RoomType.SINGLE))
            newGuest.setRoomPrice(BigDecimal.valueOf(20000.00));
        else if (bookRoomRequest.getRoomType().equals(RoomType.DOUBLE))
            newGuest.setRoomPrice(BigDecimal.valueOf(40000.00));
        else if (bookRoomRequest.getRoomType().equals(RoomType.FAMILY))
            newGuest.setRoomPrice(BigDecimal.valueOf(60000.00));
        else if (bookRoomRequest.getRoomType().equals(RoomType.APARTMENT))
            newGuest.setRoomPrice(BigDecimal.valueOf(80000.00));
        else if (bookRoomRequest.getRoomType().equals(RoomType.EXECUTIVE_SUITE))
            newGuest.setRoomPrice(BigDecimal.valueOf(100000.00));
        newGuest.setPaymentStatus(PaymentStatus.PENDING);
        guestRepository.save(newGuest);
        return new Response("Your room has been booked successfully, Kindly proceed to the payment section");
    }
}
