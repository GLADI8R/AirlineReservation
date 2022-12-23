package com.example.AirlineReservation.controller;


import com.example.AirlineReservation.model.Booking;
import com.example.AirlineReservation.model.Ticket;
import com.example.AirlineReservation.model.User;
import com.example.AirlineReservation.service.BookingService;
import com.example.AirlineReservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/api")
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;


    @GetMapping("/booking/{id}")
    public List<Ticket> getUserTickets(@PathVariable int id) {
        List<User> allUsers = userService.getAllUsers();
        User user = null;

        for(User u:allUsers) {
            if(id == u.getUser_id()) {
                user = u;
                break;
            }
        }

        List<Booking> userBookings = bookingService.getUserBookings(user);
        List<Ticket> userTickets = new ArrayList<Ticket>();

        int n = userBookings.size();

        for (Booking userBooking : userBookings) {
            Ticket ticket = bookingService.getUserTickets(user, userBooking);
            userTickets.add(ticket);
        }
        
        return userTickets;
    }
}
