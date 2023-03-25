package com.example.capstonehotels.controller;

import com.example.capstonehotels.dtos.request.BookRoomRequest;
import com.example.capstonehotels.dtos.response.ApiResponse;
import com.example.capstonehotels.services.GuestService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/capstoneHotels")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("/bookRoom")
    public ResponseEntity<?> makeRoomsReservations(@RequestBody BookRoomRequest bookRoomRequest, HttpServletRequest httpServletRequest) {
        var bookRoom = guestService.makeRoomReservation(bookRoomRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(HttpStatus.OK)
                .path(httpServletRequest.getRequestURI())
                .timeStamp(ZonedDateTime.now())
                .data(bookRoom)
                .isSuccessful(true)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }



}
