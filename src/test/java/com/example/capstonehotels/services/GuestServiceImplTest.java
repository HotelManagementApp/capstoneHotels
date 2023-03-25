package com.example.capstonehotels.services;

import com.example.capstonehotels.data.model.RoomType;
import com.example.capstonehotels.dtos.request.BookRoomRequest;
import com.example.capstonehotels.dtos.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestServiceImplTest {

    @Autowired
    private GuestService guestService;

    @Test
    void testThatGuestCanBookRoom() {
        BookRoomRequest bookRoomRequest = new BookRoomRequest();
        bookRoomRequest.setRoomType(RoomType.SINGLE);
        bookRoomRequest.setLastName("DrinkWater");
        bookRoomRequest.setFirstName("Samuel");
        bookRoomRequest.setCheckinDate("28-03-2023");
        bookRoomRequest.setCheckoutDate("30-03-2023");
        bookRoomRequest.setTelephoneNumber("560435213");
        bookRoomRequest.setEmailAddress("dsfdadfdfds@gmail.com");
        Response response = guestService.makeRoomReservation(bookRoomRequest);
        assertEquals("Your room has been booked successfully, Kindly proceed to " +
                "the payment section", response.getMessage());
    }


}