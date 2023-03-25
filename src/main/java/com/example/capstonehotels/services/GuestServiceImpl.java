package com.example.capstonehotels.services;

import com.example.capstonehotels.data.model.Guest;
import com.example.capstonehotels.data.model.PaymentStatus;
import com.example.capstonehotels.data.model.RoomType;
import com.example.capstonehotels.data.repository.GuestRepository;
import com.example.capstonehotels.dtos.request.BookRoomRequest;
import com.example.capstonehotels.dtos.request.PaymentRequest;
import com.example.capstonehotels.dtos.response.PaymentResponse;
import com.example.capstonehotels.dtos.response.Response;
import com.example.capstonehotels.utils.Validators;
import com.example.capstonehotels.utils.exceptions.CapstoneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    private final PaymentService paymentService;

    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository, PaymentService paymentService) {
        this.guestRepository = guestRepository;
        this.paymentService = paymentService;
    }

    @Override
    public Response makeRoomReservation(BookRoomRequest bookRoomRequest) {
        Guest newGuest = new Guest();
        newGuest.setCheckinDate(bookRoomRequest.getCheckinDate());
        newGuest.setCheckoutDate(bookRoomRequest.getCheckoutDate());
        newGuest.setEmailAddress(bookRoomRequest.getEmailAddress());
        if(!Validators.validateEmailAddress(bookRoomRequest.getEmailAddress()))
            throw new CapstoneException("Email is not valid");
        newGuest.setFirstName(bookRoomRequest.getFirstName());
        newGuest.setLastName(bookRoomRequest.getLastName());
        newGuest.setTelephoneNumber(bookRoomRequest.getTelephoneNumber());
        if(!Validators.validatePhoneNumber(bookRoomRequest.getTelephoneNumber()))
            throw new CapstoneException("Invalid phone number, Kindly follow this format: +XXX (XXX) XXX-XXXX");
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

    @Override
    public PaymentResponse makePayment(String telephoneNumber, PaymentRequest paymentRequest) throws IOException {
        Guest existingGuest = guestRepository.findGuestByTelephoneNumber(telephoneNumber)
                .orElseThrow(() -> new CapstoneException("This hasn't booked a room"));
        existingGuest.setPaymentStatus(PaymentStatus.PAYMENT_SUCCESSFUL);
        guestRepository.save(existingGuest);
        return paymentService.payment(paymentRequest);
    }
}
