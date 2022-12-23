package com.example.AirlineReservation.service;

import com.example.AirlineReservation.model.Flight;
import com.example.AirlineReservation.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private final FlightsRepository flightsRepository;


    public FlightServiceImpl(FlightsRepository flightsRepository) {
        this.flightsRepository = flightsRepository;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightsRepository.getAllFlights();
    }

    @Override
    public List<Integer> getFlightSeats(Flight flight) {
        return flightsRepository.getFlightSeats(flight);
    }

    @Override
    public List<Flight> searchFlights(LocalDate date, String a1, String a2) {
        return flightsRepository.searchFlights(date, a1, a2);
    }

}
