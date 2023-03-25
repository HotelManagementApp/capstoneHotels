package com.example.capstonehotels.services;

import com.example.capstonehotels.data.model.Room;
import com.example.capstonehotels.data.model.RoomStatus;
import com.example.capstonehotels.data.repository.RoomRepository;
import com.example.capstonehotels.dtos.request.AddRoomRequest;
import com.example.capstonehotels.dtos.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public Response addRoom(AddRoomRequest addRoomRequest) {
        Room room = new Room(addRoomRequest.getRoomNumber(),
                addRoomRequest.getRoomType(), addRoomRequest.getRoomPrice(), addRoomRequest.getRoomStatus());
        roomRepository.save(room);
        return new Response("Room added successfully");

    }

    @Override
    public Room getRoomById(String roomId) {
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getAvailableRooms() {

        List <Room> availableRooms = new ArrayList<>();
        List<Room> allRooms = getAllRooms();
        for (Room room: allRooms) {
            if( room.getRoomStatus().equals(RoomStatus.UNBOOKED)){
                availableRooms.add(room);
            }

        }
        return availableRooms;
    }
}
