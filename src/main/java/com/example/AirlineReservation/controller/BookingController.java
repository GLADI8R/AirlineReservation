package com.example.AirlineReservation.controller;


import com.example.AirlineReservation.model.Booking;
import com.example.AirlineReservation.model.Ticket;
import com.example.AirlineReservation.model.User;
import com.example.AirlineReservation.repository.UserRepository;
import com.example.AirlineReservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api")
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private final UserRepository userRepository;

    public BookingController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/booking/{id}")
    public List<Ticket> getUserTickets(@PathVariable int id) {
        List<User> allUsers = userRepository.getAllUsers();
        User user = null;

        for(User u:allUsers) {
            if(id == u.getUser_id()) {
                user = u;
                break;
            }
        }

        List<Booking> userBookings = bookingService.getUserBookings(user);
        List<Ticket> userTickets = null;

        int n = userBookings.size();

        for(int i=0; i<n; i++) {
            Ticket ticket = bookingService.getUserTickets(user, userBookings.get(i));
            userTickets.add(ticket);
        }
        
        return userTickets;
    }
}
