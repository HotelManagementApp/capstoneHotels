package com.example.capstonehotels.controller;

import com.example.capstonehotels.dtos.request.BookRoomRequest;
import com.example.capstonehotels.dtos.request.PaymentRequest;
import com.example.capstonehotels.dtos.response.ApiResponse;
import com.example.capstonehotels.services.GuestService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/capstoneHotels")
@CrossOrigin("*")
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

    @PostMapping("/makePayment/{telephoneNumber}")
    public ResponseEntity<?> makePayment(@PathVariable String telephoneNumber, @RequestBody PaymentRequest paymentRequest,
                                         HttpServletRequest httpServletRequest) throws IOException {
        var payment = guestService.makePayment(telephoneNumber, paymentRequest);
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(HttpStatus.OK)
                .path(httpServletRequest.getRequestURI())
                .timeStamp(ZonedDateTime.now())
                .data(payment)
                .isSuccessful(true)
                .build();

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }



}
