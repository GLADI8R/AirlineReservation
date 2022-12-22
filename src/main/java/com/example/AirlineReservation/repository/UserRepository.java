package com.example.AirlineReservation.repository;


import com.example.AirlineReservation.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> getAllUsers();
}
