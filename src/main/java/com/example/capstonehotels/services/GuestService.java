package com.example.capstonehotels.services;

import com.example.capstonehotels.dtos.request.BookRoomRequest;
import com.example.capstonehotels.dtos.response.Response;

public interface GuestService {
    Response makeRoomReservation(BookRoomRequest bookRoomRequest);

}
