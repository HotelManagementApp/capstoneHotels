package com.example.capstonehotels.data.repository;

import com.example.capstonehotels.data.model.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestRepository extends MongoRepository<Guest, String> {
}
