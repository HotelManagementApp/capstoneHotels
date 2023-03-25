package com.example.capstonehotels.dtos.request;

import com.example.capstonehotels.data.model.RoomType;
import lombok.Data;

@Data
public class BookRoomRequest {
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private RoomType roomType;
    private String emailAddress;
    private String checkinDate;
    private String checkoutDate;
}
