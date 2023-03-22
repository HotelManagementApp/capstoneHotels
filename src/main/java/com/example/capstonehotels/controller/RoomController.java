package com.example.capstonehotels.controller;

import com.example.capstonehotels.dtos.request.AddRoomRequest;
import com.example.capstonehotels.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/room")
@CrossOrigin(origins = "http://localhost:3000/")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/view_avalaible_rooms")
    public ResponseEntity<?> getAvailableRooms(){
    return ResponseEntity.ok(roomService.getAvailableRooms());
    }
    @PostMapping("/add_room")
    public ResponseEntity<?> addRoom(@RequestBody AddRoomRequest addRoomRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.addRoom(addRoomRequest));
    }
}
