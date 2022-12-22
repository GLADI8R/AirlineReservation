package com.example.AirlineReservation.service;


import com.example.AirlineReservation.model.Booking;
import com.example.AirlineReservation.model.Ticket;
import com.example.AirlineReservation.model.User;
import com.example.AirlineReservation.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getUserBookings(User user) {
        return bookingRepository.getUserBookings(user);
    }

    @Override
    public Ticket getUserTickets(User user, Booking booking) {
        return bookingRepository.getUserTickets(user, booking);
    }
}
