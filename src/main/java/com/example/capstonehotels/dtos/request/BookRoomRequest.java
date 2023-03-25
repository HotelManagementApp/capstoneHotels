package com.example.capstonehotels.dtos.request;

import com.example.capstonehotels.data.model.RoomType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRoomRequest {
    @NotBlank(message = "This field is required")
    private String firstName;
    @NotBlank(message = "This field is required")
    private String lastName;
    @NotBlank(message = "This field is required")
    private String telephoneNumber;
    @NotBlank(message = "This field is required")
    private RoomType roomType;
    @NotBlank(message = "This field is required")
    private String emailAddress;
    @NotBlank(message = "This field is required")
    private String checkinDate;
    @NotBlank(message = "This field is required")
    private String checkoutDate;
}
